package com.mutia.base.constant

import com.mutia.base.BuildConfig


object ConstKeys {
    // Used to load the 'base' library on application startup.
    init  {
        System.loadLibrary("base");
    }

    /**
     * A native method that is implemented by the 'base' native library,
     * which is packaged with this application.
     */

    private external fun getEndPoint(environment: Int): String
    private external fun getSaltKey(environment: Int): String
    private external fun getPreferenceName(environment: Int): String
    private external fun getToken(environment: Int): String
    private external fun getDigitalOceanCompleteEndPoint(environment: Int): String


    // CONST
    private const  val ENVIRONMENT = BuildConfig.SERVER_STAGING
    val END_POINT = getEndPoint(ENVIRONMENT)
    val SALT_KEY = getSaltKey(ENVIRONMENT)
    val PREFERENCE_NAME = getPreferenceName(ENVIRONMENT)
    val TOKEN = getToken(ENVIRONMENT)
    val DO_COMPLETE_END_POINT = getDigitalOceanCompleteEndPoint(ENVIRONMENT)

}