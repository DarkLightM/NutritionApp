package com.example.nutritionapp.nutritionist.domain

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.nutritionist.domain.model.AcceptDeclineStatus
import com.example.nutritionapp.nutritionist.domain.model.Status
import com.example.nutritionapp.nutritionist.domain.repository.NutritionistRepository
import javax.inject.Inject

class AcceptDeclineUseCase @Inject constructor(private val nutritionistRepository: NutritionistRepository) {
    suspend operator fun invoke(acceptDeclineStatus: AcceptDeclineStatus): WorkResult<Status> {
        return nutritionistRepository.acceptDeclineInvite(acceptDeclineStatus)
    }
}