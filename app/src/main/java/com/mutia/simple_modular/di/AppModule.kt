package com.mutia.simple_modular.di

import android.content.Context
import com.mutia.simple_modular.App
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): App = app as App

    @Singleton
    @Provides
    fun provideContext(@ApplicationContext context: App): Context = context

}