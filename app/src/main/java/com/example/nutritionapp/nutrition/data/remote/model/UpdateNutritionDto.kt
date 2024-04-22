package com.example.nutritionapp.nutrition.data.remote.model

import com.google.gson.annotations.SerializedName

data class UpdateNutritionDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("serving_size")
    val servingSize: Float,
)