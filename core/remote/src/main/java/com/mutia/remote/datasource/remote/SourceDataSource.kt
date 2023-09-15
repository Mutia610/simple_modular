package com.mutia.remote.datasource.remote

import com.mutia.remote.dto_res.source.SourceRes


interface SourceDataSource {

    suspend fun getSourceByCategory(): SourceRes

}