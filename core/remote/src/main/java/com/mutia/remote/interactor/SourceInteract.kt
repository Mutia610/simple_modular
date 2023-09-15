package com.mutia.remote.interactor

import com.mutia.base.domain.FlowUseCase
import com.mutia.base.domain.subscribers.Resource
import com.mutia.remote.dto_res.source.SourceRes
import com.mutia.remote.repository.SourceRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SourceByCategoryUseCase @Inject constructor(
    private val repository: SourceRepository
) : FlowUseCase<Nothing?, SourceRes>() {
    override suspend fun execute(parameters: Nothing?): Flow<Resource<SourceRes>> {
        return repository.getSourceByCategory()
    }
}

class SourceByCategoryLocalUseCase @Inject constructor(
    private val repository: SourceRepository
) : FlowUseCase<Nothing?, SourceRes>() {
    override suspend fun execute(parameters: Nothing?): Flow<Resource<SourceRes>> {
        return repository.getSourceByCategory()
    }
}