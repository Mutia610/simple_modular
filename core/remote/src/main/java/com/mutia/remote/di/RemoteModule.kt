package com.mutia.remote.di

import android.content.Context
import com.alibaba.sdk.android.oss.ClientConfiguration
import com.alibaba.sdk.android.oss.OSSClient
import com.alibaba.sdk.android.oss.common.auth.OSSCredentialProvider
import com.alibaba.sdk.android.oss.common.auth.OSSCustomSignerCredentialProvider
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.mutia.base.constant.Const
import com.mutia.base.constant.ConstKeys
import com.mutia.base.utils.SharedPreferenceManager
import com.mutia.remote.BuildConfig
import com.mutia.remote.exception.NoNetworkException
import com.mutia.remote.interceptor.ForbiddenInterceptor
import com.mutia.remote.interceptor.ResourceNotFoundInterceptor
import com.mutia.remote.utils.isNetworkAvailable
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Singleton
    @Provides
    fun providesRetrofit(@ApplicationContext context: Context): Retrofit {
        val gson = GsonBuilder().setDateFormat(Const.SERVER_TIME_FORMAT).create()
        val preferenceManager = SharedPreferenceManager(context)
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(ConstKeys.END_POINT)
            .client(buildRetrofitClient(context, preferenceManager))
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .build()
    }

//    private fun chuckInterceptor(@ApplicationContext context: Context)
//            : ChuckerInterceptor = ChuckerInterceptor.Builder(context)
//        .collector(ChuckerCollector(context))
//        .maxContentLength(250000L)
//        .redactHeaders(emptySet())
//        .alwaysReadResponseBody(false)
//        .build()

    private fun buildRetrofitClient(context: Context, sharePref: SharedPreferenceManager): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .readTimeout((sharePref.userRequestTime).toLong(), TimeUnit.SECONDS)
            .connectTimeout((sharePref.userRequestTime).toLong(), TimeUnit.SECONDS)
            .writeTimeout((sharePref.userRequestTime).toLong(), TimeUnit.SECONDS)
//            .authenticator(
//                TokenAuthenticator(
//                    RefreshTokenInterface().getRefreshTokenInterface(
//                        context, ConstKeys.END_POINT, sharePref
////                    chuckInterceptor(context)
//                    ), sharePref)
//            )
//            .addInterceptor(chuckInterceptor(context))
            .addInterceptor(ForbiddenInterceptor())
            .addInterceptor(ResourceNotFoundInterceptor())
            .addInterceptor(HttpLoggingInterceptor())
            .addInterceptor(Interceptor { chain: Interceptor.Chain ->
                if (context.isNetworkAvailable) {
                    val token: String = sharePref.userAccessToken
                    val request: Request = when {
                        chain.request().url.toString().contains(ConstKeys.DO_COMPLETE_END_POINT) -> {
                            chain.request().newBuilder().build()
                        }
                        token == "" -> {
                            chain.request().newBuilder()
                                .addHeader("Content-Type", "application/json")
                                .build()
                        }
                        else -> {
                            chain.request().newBuilder()
                                .addHeader("Content-Type", "application/json")
                                .addHeader("Authorization", token)
                                .build()
                        }
                    }
                    return@Interceptor chain.proceed(request)
                } else {
                    throw NoNetworkException()
                }
            })

        if (BuildConfig.DEBUG || BuildConfig.BUILD_TYPE == "debug") {
            val interceptor   = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            builder.addInterceptor(interceptor)
            builder.addInterceptor { chain ->
                val request = chain.request()
                val newRequest = request.newBuilder().build()
                chain.proceed(newRequest)
            }
        }
        return builder.build()
    }
}