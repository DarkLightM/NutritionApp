package com.example.nutritionapp.nutritionist.domain.model

import com.example.nutritionapp.nutritionist.data.remote.model.AcceptDeclineDto

data class AcceptDeclineStatus(
    val patientId: Int,
    val status: Int
) {
    fun fromDomain(): AcceptDeclineDto {
        return AcceptDeclineDto(patientId, status)
    }
}
