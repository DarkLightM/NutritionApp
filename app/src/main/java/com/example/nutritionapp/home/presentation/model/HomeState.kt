package com.example.nutritionapp.home.presentation.model

import com.example.nutritionapp.base.presentation.UiState
import com.example.nutritionapp.meal.domain.model.Meal

data class HomeState(
    val mealList: List<Meal> = emptyList()
) : UiState