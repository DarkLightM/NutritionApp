package com.example.nutritionapp.base.utils

import com.example.nutritionapp.meal.domain.model.Meal

fun Meal.countCalories(): Float {
    var result = 0F
    this.food.forEach {
        result += it.calories.toFloat()
    }
    return result
}