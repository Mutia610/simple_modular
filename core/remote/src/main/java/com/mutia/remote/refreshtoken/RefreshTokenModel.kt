package com.mutia.remote.refreshtoken

import com.google.gson.annotations.SerializedName

class RefreshTokenModel(refreshToken: String) {

    @SerializedName("refresh_token")
    var refreshToken: String? = refreshToken

}

class RefreshTokenRes {
    @SerializedName("token")
    val token: String? = null

    @SerializedName("refresh_token")
    val refreshToken: String? = null
}