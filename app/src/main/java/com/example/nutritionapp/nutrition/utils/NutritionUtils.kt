package com.example.nutritionapp.nutrition.utils

import com.example.nutritionapp.nutrition.domain.model.Nutrition

fun Nutrition.plus(): Nutrition {
    return Nutrition(
        name = name,
        calories = calories.plus(),
        servingSize = servingSize.plus(),
        fatTotal = fatTotal.plus(),
        fatSaturated = fatSaturated.plus(),
        protein = protein.plus(),
        sodium = sodium.plus(),
        potassium = potassium.plus(),
        cholesterol = cholesterol.plus(),
        carbohydrates = carbohydrates.plus(),
        fiber = fiber.plus(),
        sugar = sugar.plus(),
    )
}

fun String.plus(): String {
    return (this.toFloat() + this.toFloat() * 0.1).toString()
}