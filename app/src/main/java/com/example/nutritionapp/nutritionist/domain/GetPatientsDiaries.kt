package com.example.nutritionapp.nutritionist.domain

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.diary.domain.model.Diary
import com.example.nutritionapp.nutritionist.domain.repository.NutritionistRepository
import javax.inject.Inject

class GetPatientsDiaries @Inject constructor(private val nutritionistRepository: NutritionistRepository) {
    suspend operator fun invoke(): WorkResult<List<Diary>> {
        return nutritionistRepository.getPatientsDiaries()
    }
}