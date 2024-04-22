package com.example.nutritionapp.nutritionist.data.remote.model

import com.google.gson.annotations.SerializedName

data class UpdateDescriptionDto (
    @SerializedName("description")
    val description: String
)