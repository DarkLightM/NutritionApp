package com.example.nutritionapp.nutrition.domain.repository

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.nutrition.domain.model.Nutrition
import com.example.nutritionapp.nutrition.domain.model.UpdateNutrition

interface NutritionRepository {
    suspend fun getNutrition(query: String): WorkResult<List<Nutrition>>
    suspend fun updateNutrition(updateNutrition: UpdateNutrition): WorkResult<Nutrition>
}