package com.example.nutritionapp.login.presentation

import androidx.lifecycle.viewModelScope
import com.example.nutritionapp.base.domain.handle
import com.example.nutritionapp.base.presentation.BaseViewModel
import com.example.nutritionapp.login.data.remote.model.RegisterDto
import com.example.nutritionapp.login.domain.RegisterUseCase
import com.example.nutritionapp.login.presentation.model.RegisterEffect
import com.example.nutritionapp.login.presentation.model.RegisterState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val registerUseCase: RegisterUseCase) :
    BaseViewModel<RegisterState, RegisterEffect>(RegisterState()) {

    fun register(username: String, email: String, password: String, role: String) {
        viewModelScope.launch {
            registerUseCase(RegisterDto(username, email, password, role)).handle(
                onSuccess = { result ->
                    sendEffect(
                        RegisterEffect.RegisterSuccess(
                            result.token
                        )
                    )
                },
                onNotSuccess = { sendEffect(RegisterEffect.RegisterFail) }
            )
        }

    }
}