package com.example.network

import android.content.res.Resources
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.Protocol
import okhttp3.Response
import okhttp3.ResponseBody.Companion.toResponseBody

class DebugInterceptor(
    private val resource: Resources
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val uri = chain.request().url.toUri().toString()

        val responseString = when {
            uri.endsWith("countries") ->
                resource.openRawResource(R.raw.countries).asString()
            else -> ""
        }

        return chain.proceed(chain.request())
            .newBuilder()
            .code(200)
            .protocol(Protocol.HTTP_2)
            .message(responseString)
            .body(
                responseString
                    .toByteArray()
                    .toResponseBody(
                        "application/json".toMediaTypeOrNull()
                    )
            ).build()
    }
}