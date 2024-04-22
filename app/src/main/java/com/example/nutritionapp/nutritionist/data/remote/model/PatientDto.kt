package com.example.nutritionapp.nutritionist.data.remote.model

import com.example.nutritionapp.nutritionist.domain.model.Patient
import com.google.gson.annotations.SerializedName

data class PatientDto(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("status")
    val status: Int
) {
    fun toDomain(): Patient {
        return Patient(id, name, status)
    }
}
