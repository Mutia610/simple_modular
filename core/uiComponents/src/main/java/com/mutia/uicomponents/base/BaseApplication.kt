package com.mutia.uicomponents.base

import android.app.Application

abstract class BaseApplication: Application() {
    abstract fun getBaseUrl(): String
}