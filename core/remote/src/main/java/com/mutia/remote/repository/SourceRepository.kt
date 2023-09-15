package com.mutia.remote.repository

import com.mutia.base.domain.subscribers.Resource
import com.mutia.remote.dto_res.source.SourceRes
import kotlinx.coroutines.flow.Flow

interface SourceRepository {
    // Remote and cache
    suspend fun getSourceByCategory(): Flow<Resource<SourceRes>>
}