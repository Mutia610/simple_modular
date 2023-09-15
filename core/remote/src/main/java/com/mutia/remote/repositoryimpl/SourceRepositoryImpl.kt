package com.mutia.remote.repositoryimpl


import com.mutia.base.domain.subscribers.DataSource
import com.mutia.base.domain.subscribers.Resource
import com.mutia.base.utils.SchedulerProvider
import com.mutia.remote.datasource.remote.SourceDataSource
import com.mutia.remote.datasource.stub.SourceStubDataSource
import com.mutia.remote.dto_res.source.SourceRes
import com.mutia.remote.repository.SourceRepository
import com.mutia.remote.utils.ErrorCodesMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SourceRepositoryImpl @Inject constructor(
    private val remoteSource: SourceDataSource,
    private val stubDataSource: SourceStubDataSource,
    private val schedulerProvider: SchedulerProvider,
    private val errorCodesMapper: ErrorCodesMapper
) : SourceRepository {

    private var isUsingDummyDataSource = true

    override suspend fun getSourceByCategory(): Flow<Resource<SourceRes>> =
        flow {
            if (isUsingDummyDataSource) {
                emit(Resource.Success(data = stubDataSource.getSourceByCategory(), DataSource.REMOTE))
            } else {
                emit(Resource.Success(data = remoteSource.getSourceByCategory(), DataSource.REMOTE))
            }
        }
}