package com.mutia.navigator.di

import com.mutia.navigator.navigation.NavigationActions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object NavigatorAction {
    @Provides
    fun provideNavigationActions(): NavigationActions {
        return NavigationActions()
    }
}