package com.example.nutritionapp.home.presentation

import androidx.lifecycle.ViewModel
import com.example.nutritionapp.login.domain.AuthUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val loginUseCase: AuthUseCase): ViewModel() {
    // TODO: Implement the ViewModel
}