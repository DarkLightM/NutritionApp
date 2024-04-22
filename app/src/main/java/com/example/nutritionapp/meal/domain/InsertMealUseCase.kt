package com.example.nutritionapp.meal.domain

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.meal.domain.model.Meal
import com.example.nutritionapp.meal.domain.repository.MealRepository
import javax.inject.Inject

class InsertMealUseCase @Inject constructor(private val mealRepository: MealRepository) {
    suspend operator fun invoke(meal: Meal): WorkResult<Meal> {
        return mealRepository.insertMeal(meal)
    }
}