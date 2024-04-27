package com.example.nutritionapp.meal.presentation.model

import com.example.nutritionapp.base.presentation.UiState
import com.example.nutritionapp.nutrition.domain.model.Nutrition

data class MealState (
    val id: Int = -1,
    val name: String = "",
    val date: String = "",
    val food: List<Nutrition> = emptyList()
): UiState