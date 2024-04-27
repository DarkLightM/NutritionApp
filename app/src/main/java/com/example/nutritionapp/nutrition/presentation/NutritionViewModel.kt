package com.example.nutritionapp.nutrition.presentation

import androidx.lifecycle.viewModelScope
import com.example.nutritionapp.base.domain.handle
import com.example.nutritionapp.base.presentation.BaseViewModel
import com.example.nutritionapp.meal.domain.InsertMealUseCase
import com.example.nutritionapp.meal.domain.model.Meal
import com.example.nutritionapp.nutrition.domain.GetNutritionUseCase
import com.example.nutritionapp.nutrition.presentation.model.NutritionEffect
import com.example.nutritionapp.nutrition.presentation.model.NutritionState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class NutritionViewModel @Inject constructor(
    private val getNutritionUseCase: GetNutritionUseCase,
    private val insertMealUseCase: InsertMealUseCase
) :
    BaseViewModel<NutritionState, NutritionEffect>(NutritionState()) {

    fun getNutrition(query: String) = viewModelScope.launch {
        getNutritionUseCase(query).handle(
            onSuccess = { nutrition -> updateState { it.copy(nutrition = nutrition, name = query) } },
            onNotSuccess = { sendEffect(NutritionEffect.NutritionLoadFailed) }
        )
    }

    fun saveMeal() = viewModelScope.launch {
        insertMealUseCase(Meal(-1, state.value.name, LocalDate.now().toString(), state.value.nutrition)).handle(
            onSuccess = {},
            onNotSuccess = {}
        )
    }
}