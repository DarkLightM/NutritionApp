package com.example.nutritionapp.diary.domain.model

import com.example.nutritionapp.meal.domain.model.Meal

data class Diary(
    val userId: Int,
    val userName: String,
    val mealList: List<Meal>
)
