package com.example.nutritionapp.nutritionist.domain

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.nutritionist.domain.model.Status
import com.example.nutritionapp.nutritionist.domain.repository.NutritionistRepository
import javax.inject.Inject

class InviteDoctorUseCase @Inject constructor(private val nutritionistRepository: NutritionistRepository) {
    suspend operator fun invoke(id: Int): WorkResult<Status> {
        return nutritionistRepository.inviteDoctor(id)
    }
}