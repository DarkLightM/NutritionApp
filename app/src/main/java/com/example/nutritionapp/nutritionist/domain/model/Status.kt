package com.example.nutritionapp.nutritionist.domain.model

data class Status(
    val id: Int,
    val userId: Int,
    val nutritionistId: Int,
    val status: Int
)
