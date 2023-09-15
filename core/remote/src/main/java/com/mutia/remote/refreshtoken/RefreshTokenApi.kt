package com.mutia.remote.refreshtoken

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RefreshTokenApi {

    @POST("account/refresh_token")
    fun refreshToken(@Body req: RefreshTokenModel): Call<RefreshTokenRes?>
}