package com.example.nutritionapp.login.data.remote.model

import com.google.gson.annotations.SerializedName

data class AuthDtoResult (
    @SerializedName("access_token")
    val accessToken: String
)