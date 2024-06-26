package com.example.nutritionapp.login.data.remote.model

import com.google.gson.annotations.SerializedName

data class AuthDto(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)
