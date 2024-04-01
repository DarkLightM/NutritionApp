package com.example.nutritionapp.login.data.remote.model

import com.google.gson.annotations.SerializedName

data class RegisterDtoResult (
    @SerializedName("id")
    val id: Int,
    @SerializedName("email")
    val email: String,
    @SerializedName("username")
    val userName: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("role_id")
    val roleId: Int
)