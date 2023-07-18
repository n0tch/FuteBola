package com.example.network

import okhttp3.Interceptor
import okhttp3.Response

class ReleaseInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return chain.proceed(chain.request())
    }
}