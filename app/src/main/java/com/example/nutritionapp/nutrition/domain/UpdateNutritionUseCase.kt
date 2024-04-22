package com.example.nutritionapp.nutrition.domain

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.nutrition.domain.model.Nutrition
import com.example.nutritionapp.nutrition.domain.model.UpdateNutrition
import com.example.nutritionapp.nutrition.domain.repository.NutritionRepository
import javax.inject.Inject

class UpdateNutritionUseCase @Inject constructor(private val nutritionRepository: NutritionRepository) {
    suspend operator fun invoke(updateNutrition: UpdateNutrition): WorkResult<Nutrition> {
        return nutritionRepository.updateNutrition(updateNutrition)
    }
}