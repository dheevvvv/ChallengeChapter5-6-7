package com.example.challengechapter5.networking

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject


class ApiKeyInterceptor @Inject constructor(val apiKey:String):Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newUrl = request.url.newBuilder().addQueryParameter("api_key", apiKey).build()
        val newRequest = request.newBuilder().url(newUrl).build()
        return chain.proceed(newRequest)
    }
}