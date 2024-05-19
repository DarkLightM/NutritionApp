package com.example.nutritionapp.login.presentation.model

import com.example.nutritionapp.base.presentation.UiState

data class AuthState(
    val role: String = "",
    val token: String = ""
) : UiState