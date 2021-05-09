package com.criniguez.platziconf.network

interface Callback<T> {
    fun onSuccess(result: T?)
    fun onFailed(exception: Exception)
}