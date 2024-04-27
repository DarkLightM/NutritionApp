package com.example.nutritionapp.meal.domain.repository

import com.example.nutritionapp.base.data.remote.model.OperationModel
import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.meal.domain.model.Meal

interface MealRepository {
    suspend fun getMeal(id: Int): WorkResult<Meal>
    suspend fun insertMeal(meal: Meal): WorkResult<Meal>
    suspend fun deleteMeal(id: Int): WorkResult<OperationModel>
}