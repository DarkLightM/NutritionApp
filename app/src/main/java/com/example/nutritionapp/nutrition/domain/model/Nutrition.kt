package com.example.nutritionapp.nutrition.domain.model

import com.example.nutritionapp.nutrition.data.remote.model.NutritionDto

data class Nutrition(
    val id: Int,
    val name: String,
    val calories: String,
    val servingSize: String,
    val fatTotal: String,
    val fatSaturated: String,
    val protein: String,
    val sodium: String,
    val potassium: String,
    val cholesterol: String,
    val carbohydrates: String,
    val fiber: String,
    val sugar: String,
) {
    fun fromDomain(): NutritionDto {
        return NutritionDto(
            id,
            name,
            calories.toFloat(),
            servingSize.toFloat(),
            fatTotal.toFloat(),
            fatSaturated.toFloat(),
            protein.toFloat(),
            sodium.toFloat(),
            potassium.toFloat(),
            cholesterol.toFloat(),
            carbohydrates.toFloat(),
            fiber.toFloat(),
            sugar.toFloat()
        )
    }
}
