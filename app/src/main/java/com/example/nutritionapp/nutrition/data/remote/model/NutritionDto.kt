package com.example.nutritionapp.nutrition.data.remote.model

import com.example.nutritionapp.nutrition.domain.model.Nutrition
import com.google.gson.annotations.SerializedName

data class NutritionDto(
    @SerializedName("id")
    val id: Int = -1,
    @SerializedName("name")
    val name: String,
    @SerializedName("calories")
    val calories: Float,
    @SerializedName("serving_size_g")
    val servingSize: Float,
    @SerializedName("fat_total_g")
    val fatTotal: Float,
    @SerializedName("fat_saturated_g")
    val fatSaturated: Float,
    @SerializedName("protein_g")
    val protein: Float,
    @SerializedName("sodium_mg")
    val sodium: Float,
    @SerializedName("potassium_mg")
    val potassium: Float,
    @SerializedName("cholesterol_mg")
    val cholesterol: Float,
    @SerializedName("carbohydrates_total_g")
    val carbohydrates: Float,
    @SerializedName("fiber_g")
    val fiber: Float,
    @SerializedName("sugar_g")
    val sugar: Float,
) {
    fun toDomain(): Nutrition {
        return Nutrition(
            id,
            name,
            calories.toString(),
            servingSize.toString(),
            fatTotal.toString(),
            fatSaturated.toString(),
            protein.toString(),
            sodium.toString(),
            potassium.toString(),
            cholesterol.toString(),
            carbohydrates.toString(),
            fiber.toString(),
            sugar.toString()
        )
    }
}
