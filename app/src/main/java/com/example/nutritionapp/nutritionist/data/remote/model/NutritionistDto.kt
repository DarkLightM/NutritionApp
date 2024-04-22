package com.example.nutritionapp.nutritionist.data.remote.model

import com.example.nutritionapp.nutritionist.domain.model.Nutritionist
import com.google.gson.annotations.SerializedName

data class NutritionistDto (
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("rate")
    val rate: Int
) {
    fun toDomain(): Nutritionist {
        return Nutritionist(id, name, description, rate)
    }
}