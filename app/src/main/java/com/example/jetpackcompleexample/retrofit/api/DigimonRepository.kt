package com.example.jetpackcompleexample.retrofit.api

import com.example.jetpackcompleexample.retrofit.response.Digimon
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class DigimonRepository @Inject constructor(private val api: DigimonApi) {
    suspend fun getDigimon(): List<Digimon> {
        try {
            return api.getDigimon()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return emptyList()
    }
}