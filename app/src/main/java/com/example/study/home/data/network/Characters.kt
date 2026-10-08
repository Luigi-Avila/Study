package com.example.study.home.data.network

import com.example.study.home.data.model.ResponseDAO
import retrofit2.Response
import retrofit2.http.GET

interface Characters {
    @GET("character")
    suspend fun getAllCharacters(): Response<ResponseDAO>
}