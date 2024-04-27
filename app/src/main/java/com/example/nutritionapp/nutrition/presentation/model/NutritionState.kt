package com.example.nutritionapp.nutrition.presentation.model

import com.example.nutritionapp.base.presentation.UiState
import com.example.nutritionapp.nutrition.domain.model.Nutrition

data class NutritionState(
    val nutrition: List<Nutrition> = emptyList(),
    val name: String = ""
) : UiState