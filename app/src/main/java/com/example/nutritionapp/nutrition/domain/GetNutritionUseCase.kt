package com.example.nutritionapp.nutrition.domain

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.nutrition.domain.model.Nutrition
import com.example.nutritionapp.nutrition.domain.repository.NutritionRepository
import javax.inject.Inject

class GetNutritionUseCase @Inject constructor(private val nutritionRepository: NutritionRepository) {
    suspend operator fun invoke(query: String): WorkResult<List<Nutrition>> {
        return nutritionRepository.getNutrition(query)
    }
}