package com.example.nutritionapp.nutrition.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nutritionapp.base.domain.handle
import com.example.nutritionapp.base.presentation.BaseViewModel
import com.example.nutritionapp.nutrition.domain.GetNutritionUseCase
import com.example.nutritionapp.nutrition.presentation.model.NutritionEffect
import com.example.nutritionapp.nutrition.presentation.model.NutritionState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NutritionViewModel @Inject constructor(private val getNutritionUseCase: GetNutritionUseCase) :
    BaseViewModel<NutritionState, NutritionEffect>(NutritionState()) {

    fun getNutrition(query: String) = viewModelScope.launch {
        getNutritionUseCase(query).handle(
            onSuccess = { nutrition -> updateState { it.copy(nutrition = nutrition) } },
            onNotSuccess = { sendEffect(NutritionEffect.NutritionLoadFailed) }
        )
    }
}