package com.example.study.home.core.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Network {
    fun getRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl("https://rickandmortyapi.com/api/").addConverterFactory(
            GsonConverterFactory.create()
        ).build()
}