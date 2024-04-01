package com.example.nutritionapp.login.presentation

import android.content.SharedPreferences
import android.util.Log
import androidx.core.content.edit
import androidx.lifecycle.viewModelScope
import com.example.nutritionapp.base.domain.handle
import com.example.nutritionapp.base.presentation.BaseViewModel
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
            authUseCase(email, password).handle(
                onSuccess = { token ->
                    Log.d("My log", token.accessToken)
                    sharedPreferences.edit { putString("token", token.accessToken) }
                    sendEffect(AuthEffect.AuthSuccess)
                },
                onNotSuccess = { error -> Log.d("My log", error.toString())
                    sendEffect(AuthEffect.AuthFail) }
            )
        }
    }
}