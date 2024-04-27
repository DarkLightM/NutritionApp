package com.example.nutritionapp.meal.domain

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.meal.domain.model.Meal
import com.example.nutritionapp.meal.domain.repository.MealRepository
import javax.inject.Inject

class GetMealUseCase @Inject constructor(private val mealRepository: MealRepository) {
    suspend operator fun invoke(id: Int): WorkResult<Meal> {
        return mealRepository.getMeal(id)
    }
}