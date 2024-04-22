package com.example.nutritionapp.nutritionist.domain

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.nutritionist.domain.model.Patient
import com.example.nutritionapp.nutritionist.domain.repository.NutritionistRepository
import javax.inject.Inject

class GetDoctorsPatientsUseCase @Inject constructor(private val nutritionistRepository: NutritionistRepository) {
    suspend operator fun invoke(): WorkResult<List<Patient>> {
        return nutritionistRepository.getPatients()
    }
}