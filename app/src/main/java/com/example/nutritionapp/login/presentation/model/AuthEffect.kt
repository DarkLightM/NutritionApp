package com.example.nutritionapp.login.presentation.model

import com.example.nutritionapp.base.presentation.UiEffect

sealed class AuthEffect : UiEffect {
    object AuthSuccess: AuthEffect()
    object AuthFail: AuthEffect()
}