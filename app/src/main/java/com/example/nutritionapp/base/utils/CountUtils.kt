package com.example.nutritionapp.base.utils

import com.example.nutritionapp.meal.domain.model.Meal

fun Meal.countCalories(): String {
    var result = 0F
    this.food.forEach {
        result += it.calories.toFloat()
    }
    return String.format("%.1f", result)
}