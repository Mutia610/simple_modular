package com.mutia.remote.usecase

import android.content.Context
import com.mutia.remote.interactor.SourceByCategoryLocalUseCase
import com.mutia.remote.interactor.SourceByCategoryUseCase
import com.mutia.remote.repository.SourceRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepoUseCaseModule {

    // REMOTE USE CASE
    /** Source Interact */
    @Provides
    @ViewModelScoped
    fun provideGetSourceByCategory(
        sourceRepository: SourceRepository
    ): SourceByCategoryUseCase {
        return SourceByCategoryUseCase(sourceRepository)
    }


    // LOCAL USE CASE
    /** Source Interact */
    @Provides
    @ViewModelScoped
    fun provideGetSavedSource(
        sourceRepository: SourceRepository
    ): SourceByCategoryLocalUseCase {
        return SourceByCategoryLocalUseCase(sourceRepository)
    }

}