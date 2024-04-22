package com.example.nutritionapp.login.data.remote.model

import com.google.gson.annotations.SerializedName

data class RegisterDtoResult (
    @SerializedName("token")
    val token: String
)