package com.mutia.remote.datasourceimpl.remote


import com.mutia.remote.api.SourceApi
import com.mutia.remote.datasource.remote.SourceDataSource
import com.mutia.remote.dto_res.source.SourceRes
import javax.inject.Inject

class SourceDataSourceImpl @Inject constructor(
    private val sourceApi: SourceApi
) : SourceDataSource {

    override suspend fun getSourceByCategory(): SourceRes =
        sourceApi.getSource()

}