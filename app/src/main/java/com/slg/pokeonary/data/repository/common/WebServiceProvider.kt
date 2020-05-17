package com.slg.pokeonary.data.repository.common

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebServiceProvider(private val baseUrl: String) {

    fun <T> getWebService(service: Class<T>): T = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(service)
}
