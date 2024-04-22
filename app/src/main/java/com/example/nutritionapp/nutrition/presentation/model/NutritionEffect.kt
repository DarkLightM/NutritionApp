package com.example.nutritionapp.nutrition.presentation.model

import com.example.nutritionapp.base.presentation.UiEffect
import com.example.nutritionapp.nutrition.domain.model.Nutrition

sealed class NutritionEffect: UiEffect {
    data object NutritionLoadFailed: NutritionEffect()
    class OpenNutrition(val nutrition: Nutrition): NutritionEffect()
}