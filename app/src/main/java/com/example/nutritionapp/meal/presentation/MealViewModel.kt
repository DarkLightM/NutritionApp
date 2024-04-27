package com.example.nutritionapp.meal.presentation

import androidx.lifecycle.viewModelScope
import com.example.nutritionapp.base.domain.handle
import com.example.nutritionapp.base.presentation.BaseViewModel
import com.example.nutritionapp.meal.domain.DeleteMealUseCase
import com.example.nutritionapp.meal.domain.GetMealUseCase
import com.example.nutritionapp.meal.presentation.model.MealEffect
import com.example.nutritionapp.meal.presentation.model.MealState
import com.example.nutritionapp.nutrition.domain.UpdateNutritionUseCase
import com.example.nutritionapp.nutrition.domain.model.UpdateNutrition
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MealViewModel @Inject constructor(
    private val getMealUseCase: GetMealUseCase,
    private val updateNutritionUseCase: UpdateNutritionUseCase,
    private val deleteMealUseCase: DeleteMealUseCase
) : BaseViewModel<MealState, MealEffect>(
    MealState()
) {
    fun loadMeal(id: Int) = viewModelScope.launch {
        getMealUseCase(id).handle(
            onSuccess = { meal ->
                updateState {
                    it.copy(
                        id = meal.id,
                        name = meal.name,
                        date = meal.date,
                        food = meal.food
                    )
                }
            },
            onNotSuccess = {}
        )
    }

    fun updateNutrition(updateNutrition: UpdateNutrition) = viewModelScope.launch {
        updateNutritionUseCase(updateNutrition).handle(
            onSuccess = { loadMeal(it.id) },
            onNotSuccess = {}
        )
    }

    fun deleteMeal() = viewModelScope.launch {
        deleteMealUseCase(state.value.id).handle(
            onSuccess = { sendEffect(MealEffect.DeleteMealSuccess) },
            onNotSuccess = {}
        )
    }
}