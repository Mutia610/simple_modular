/*
package com.mutia.remote.interceptor

import com.mutia.base.utils.SharedPreferenceManager
import com.mutia.remote.refreshtoken.RefreshTokenApi
import com.mutia.remote.refreshtoken.RefreshTokenModel
import com.mutia.remote.refreshtoken.RefreshTokenRes
import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import retrofit2.Call

class TokenAuthenticator (
    private val refreshTokenInterface: RefreshTokenApi,
    private val preferenceInterface: SharedPreferenceManager
) : Authenticator {

    override fun authenticate(route: Route?, response: Response): Request? {
        var request: Request? = null
        val callback: Call<RefreshTokenRes?> = refreshTokenInterface.refreshToken(
            RefreshTokenModel(preferenceInterface.userRefreshToken)
        )
        val refreshTokenResponse = callback.execute()
        if (callback.isExecuted && refreshTokenResponse.isSuccessful
            && refreshTokenResponse.body() != null
        ) {
            preferenceInterface.userRefreshToken = refreshTokenResponse.body()!!.refreshToken ?: ""
            preferenceInterface.userAccessToken = "Bearer " + refreshTokenResponse.body()!!.token ?: ""
            saveDecodedTokenToRealm(refreshTokenResponse.body()!!.token ?: "")
            request = response.request.newBuilder()
                .header("Content-Type", "application/json")
                .header("Authorization", preferenceInterface.userAccessToken)
                .build()
            return request
        }
        return request
    }

    private fun saveDecodedTokenToRealm(token: String) {
        */
/*Realm.getDefaultInstance().use { realm ->
            realm.beginTransaction()
            val AuthObject: AuthObject = Gson().fromJson(token.getDecodedJWT(), AuthObject::class.java)
            realm.delete(AuthObject::class.java)
            realm.copyToRealmOrUpdate(AuthObject)
            realm.commitTransaction()
        }*//*

    }
}*/
