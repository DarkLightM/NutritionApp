package com.example.nutritionapp.login.data.remote.model

import com.google.gson.annotations.SerializedName

data class AuthDtoResult (
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("token")
    val token: String,
    @SerializedName("role")
    val role: String
)