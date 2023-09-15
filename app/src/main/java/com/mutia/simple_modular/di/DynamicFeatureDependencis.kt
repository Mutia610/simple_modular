package com.mutia.simple_modular.di

import com.mutia.remote.repository.SourceRepository
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface DynamicFeatureDependencies {
    /** */
    fun sourceRepository(): SourceRepository

    /** */
}