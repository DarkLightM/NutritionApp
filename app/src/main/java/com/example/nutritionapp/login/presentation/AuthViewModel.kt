package com.example.nutritionapp.login.presentation

import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.lifecycle.viewModelScope
import com.example.nutritionapp.base.domain.handle
import com.example.nutritionapp.base.presentation.BaseViewModel
import com.example.nutritionapp.login.data.remote.model.AuthDto
import com.example.nutritionapp.login.domain.AuthUseCase
import com.example.nutritionapp.login.presentation.model.AuthEffect
import com.example.nutritionapp.login.presentation.model.AuthState
import com.example.nutritionapp.sharedprefs.model.SharedPrefs
import com.example.nutritionapp.sharedprefs.model.SharedPrefsType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    @SharedPrefs(SharedPrefsType.DEFAULT) private val sharedPreferences: SharedPreferences,
    private val authUseCase: AuthUseCase
) :
    BaseViewModel<AuthState, AuthEffect>(AuthState()) {
    fun auth(email: String, password: String) {
        viewModelScope.launch {
            authUseCase(AuthDto(email, password)).handle(
                onSuccess = { token ->
                    sharedPreferences.edit { putString("token", token.token) }
                    sendEffect(AuthEffect.AuthSuccess)
                },
                onNotSuccess = {
                    sendEffect(AuthEffect.AuthFail)
                }
            )
        }
    }
}