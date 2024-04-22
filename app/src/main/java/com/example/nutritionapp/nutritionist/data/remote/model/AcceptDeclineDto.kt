package com.example.nutritionapp.nutritionist.data.remote.model

import com.example.nutritionapp.nutritionist.domain.model.AcceptDeclineStatus
import com.google.gson.annotations.SerializedName

data class AcceptDeclineDto(
    @SerializedName("patient_id")
    val patientId: Int,
    @SerializedName("status")
    val status: Int
) {
    fun toDomain(): AcceptDeclineStatus {
        return AcceptDeclineStatus(patientId, status)
    }
}
