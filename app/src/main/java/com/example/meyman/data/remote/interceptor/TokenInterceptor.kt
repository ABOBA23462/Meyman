package com.example.meyman.data.remote.interceptor

import okhttp3.Interceptor
import okhttp3.Response

class TokenInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val url = request.url.newBuilder().addQueryParameter("key", "").build()
        request = request.newBuilder().url(url).build()
        return chain.proceed(request)
    }
}