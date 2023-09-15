package com.mutia.remote.refreshtoken

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.mutia.base.constant.Const
import com.mutia.base.utils.SharedPreferenceManager
import com.mutia.remote.exception.NoNetworkException
import com.mutia.remote.utils.isNetworkAvailable
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RefreshTokenInterface {
    fun getRefreshTokenInterface(
        context: Context, endpoint: String,
        sharePref: SharedPreferenceManager,
//    chuck: ChuckerInterceptor
    ): RefreshTokenApi {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout((sharePref.userRequestTime).toLong(), TimeUnit.SECONDS)
            .connectTimeout((sharePref.userRequestTime).toLong(), TimeUnit.SECONDS)
            .writeTimeout((sharePref.userRequestTime).toLong(), TimeUnit.SECONDS)
//            .addInterceptor(RefreshTokenFailedInterceptor(context))
//        .addInterceptor(chuck)
            .addInterceptor(logging)
            .addInterceptor(Interceptor { chain: Interceptor.Chain ->
                if (context.isNetworkAvailable) {
                    val request: Request = when (val token: String = sharePref.userAccessToken) {
                        "" -> {
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
            }).build()

        val gson: Gson = GsonBuilder()
            .setLenient()
            .setDateFormat(Const.SERVER_TIME_FORMAT)
            .create()

        val retrofit = Retrofit.Builder().baseUrl(endpoint)
            .client(client)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        return retrofit.create(RefreshTokenApi::class.java)
    }
}