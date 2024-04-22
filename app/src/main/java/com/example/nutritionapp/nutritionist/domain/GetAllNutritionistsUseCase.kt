package com.example.nutritionapp.nutritionist.domain

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.nutritionist.domain.model.Nutritionist
import com.example.nutritionapp.nutritionist.domain.repository.NutritionistRepository
import javax.inject.Inject

class GetAllNutritionistsUseCase @Inject constructor(private val nutritionistRepository: NutritionistRepository) {
    suspend operator fun invoke(): WorkResult<List<Nutritionist>> {
        return nutritionistRepository.getAllNutritionists()
    }
}