package com.example.jetpackcompleexample.retrofit.response

import com.google.gson.annotations.SerializedName

data class Digimon(
    @SerializedName("name")
    val name: String,
    @SerializedName("img")
    val img: String,
    @SerializedName("level")
    val level: String
)
