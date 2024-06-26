package com.example.nutritionapp.login.data.remote.model

import com.google.gson.annotations.SerializedName

data class RegisterDto (
    @SerializedName("login")
    val login: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("role")
    val role: String
)