package com.mutia.base.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.mutia.base.utils.ApplicationDispatchersProvider
import com.mutia.base.utils.SchedulerProvider
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    @Singleton
    fun provideSchedulerProvider(): SchedulerProvider = ApplicationDispatchersProvider()

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder().create()
    }
}