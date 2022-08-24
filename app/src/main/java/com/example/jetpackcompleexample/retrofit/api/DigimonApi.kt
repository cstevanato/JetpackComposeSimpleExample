package com.example.jetpackcompleexample.retrofit.api

import com.example.jetpackcompleexample.retrofit.response.Digimon
import retrofit2.http.GET

interface DigimonApi {
    @GET("digimon")
    suspend fun getDigimon(): List<Digimon>
}