package com.example.nutritionapp.nutritionist.domain

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.nutritionist.domain.model.Nutritionist
import com.example.nutritionapp.nutritionist.domain.repository.NutritionistRepository
import javax.inject.Inject

class UpdateDoctorDescriptionUseCase @Inject constructor(private val nutritionistRepository: NutritionistRepository) {
    suspend operator fun invoke(newDesc: String): WorkResult<Nutritionist> {
        return nutritionistRepository.updateDoctorDescription(newDesc)
    }
}