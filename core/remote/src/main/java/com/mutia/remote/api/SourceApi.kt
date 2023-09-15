package com.mutia.remote.api

import com.mutia.base.api.ApiEndPoint
import com.mutia.remote.dto_res.source.SourceRes
import retrofit2.http.GET
import retrofit2.http.Query

interface SourceApi {

    // GET

    @GET(ApiEndPoint.GET_SOURCE_BY_CATEGORY)
    suspend fun getSource(): SourceRes

}