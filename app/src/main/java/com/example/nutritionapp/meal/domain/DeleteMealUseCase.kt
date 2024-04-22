package com.example.nutritionapp.meal.domain

import com.example.nutritionapp.base.data.remote.model.OperationModel
import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.meal.domain.repository.MealRepository
import javax.inject.Inject

class DeleteMealUseCase @Inject constructor(private val mealRepository: MealRepository) {
    suspend operator fun invoke(id: Int): WorkResult<OperationModel> {
        return mealRepository.deleteMeal(id)
    }
}