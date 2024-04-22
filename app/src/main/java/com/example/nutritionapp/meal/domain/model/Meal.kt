package com.example.nutritionapp.meal.domain.model

import com.example.nutritionapp.meal.data.remote.model.MealDto
import com.example.nutritionapp.nutrition.domain.model.Nutrition

data class Meal(
    val id: Int,
    val name: String,
    val date: String,
    val food: List<Nutrition>
) {
    fun fromDomain(): MealDto {
        return MealDto(id, name, date, food.map { it.fromDomain() })
    }
}
