package com.mutia.remote.di

import android.content.Context
import com.mutia.base.utils.SchedulerProvider
import com.mutia.local.dao.SourceDao
import com.mutia.local.util.StubUtil
import com.mutia.remote.api.SourceApi
import com.mutia.remote.datasource.remote.SourceDataSource
import com.mutia.remote.datasource.stub.SourceStubDataSource
import com.mutia.remote.datasourceimpl.remote.SourceDataSourceImpl
import com.mutia.remote.datasourceimpl.stub.SourceStubDataSourceImpl
import com.mutia.remote.repository.SourceRepository
import com.mutia.remote.repositoryimpl.SourceRepositoryImpl
import com.mutia.remote.utils.ErrorCodesMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataSourceModule {

    /** Source DataSource */
    @Singleton
    @Provides
    fun provideSourceStubDataSource(
        @ApplicationContext context: Context,
        stubUtil: StubUtil
    ): SourceStubDataSource = SourceStubDataSourceImpl(
        context, stubUtil)

    @Singleton
    @Provides
    fun provideSourceDataSource(
        sourceApi: SourceApi
    ): SourceDataSource = SourceDataSourceImpl(sourceApi)

    // API
    @Singleton
    @Provides
    fun provideSourceApi(retrofit: Retrofit): SourceApi = retrofit.create(
        SourceApi::class.java
    )

    // REPO
    @Singleton
    @Provides
    fun provideSourceRepository(source: SourceDataSource, stubSource: SourceStubDataSource, schedulerProvider: SchedulerProvider):
            SourceRepository = SourceRepositoryImpl(source, stubSource, schedulerProvider, ErrorCodesMapper())

}