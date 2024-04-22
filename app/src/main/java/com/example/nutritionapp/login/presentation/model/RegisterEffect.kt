package com.example.nutritionapp.login.presentation.model

import com.example.nutritionapp.base.presentation.UiEffect

sealed class RegisterEffect : UiEffect {
    class RegisterSuccess(val token: String) : RegisterEffect()
    object RegisterFail : RegisterEffect()
}