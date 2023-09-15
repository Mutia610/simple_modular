package com.mutia.base.utils

abstract class BaseMapper<in T, out R> {
    abstract fun map(value: T): R
}
