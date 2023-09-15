package com.mutia.remote.datasource.stub

import com.mutia.remote.dto_res.source.SourceRes


interface SourceStubDataSource {

    suspend fun getSourceByCategory(): SourceRes
}