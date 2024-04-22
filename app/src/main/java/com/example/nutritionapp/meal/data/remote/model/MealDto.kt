package com.example.nutritionapp.meal.data.remote.model

import com.example.nutritionapp.meal.domain.model.Meal
import com.example.nutritionapp.nutrition.data.remote.model.NutritionDto
import com.google.gson.annotations.SerializedName

data class MealDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("food")
    val food: List<NutritionDto>
) {
    fun toDomain(): Meal {
        return Meal(id, name, date, food.map { it.toDomain() })
    }
}
