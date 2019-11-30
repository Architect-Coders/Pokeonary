package com.slg.pokeonary.data.repository.common

import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class WebServiceProvider(val context: Context) {

    fun <T> getWebService(service: Class<T>): T = Retrofit.Builder()
        .baseUrl("https://pokeapi.co/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(service)
}
