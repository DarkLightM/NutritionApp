package com.example.nutritionapp.nutrition.presentation.model

import com.example.nutritionapp.base.presentation.UiEffect

sealed class NutritionEffect: UiEffect {
    data object NutritionLoadFailed: NutritionEffect()
}