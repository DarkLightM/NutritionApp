package com.example.nutritionapp.nutrition.domain.model

import com.example.nutritionapp.nutrition.data.remote.model.UpdateNutritionDto

data class UpdateNutrition(
    val id: Int,
    val servingSize: String,
) {
    fun fromDomain(): UpdateNutritionDto {
        return UpdateNutritionDto(id, servingSize.toFloat())
    }
}
