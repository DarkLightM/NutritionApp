package com.example.nutritionapp.meal.presentation.model

import com.example.nutritionapp.base.presentation.UiEffect

sealed class MealEffect: UiEffect {
    data object DeleteMealSuccess: MealEffect()
}