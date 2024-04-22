package com.example.nutritionapp.nutritionist.data.remote.model

import com.example.nutritionapp.nutritionist.domain.model.Status
import com.google.gson.annotations.SerializedName

data class StatusDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("nutritionist_id")
    val nutritionistId: Int,
    @SerializedName("status")
    val status: Int
) {
    fun toDomain(): Status {
        return Status(id, userId, nutritionistId, status)
    }
}
