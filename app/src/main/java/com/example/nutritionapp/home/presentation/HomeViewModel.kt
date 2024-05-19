package com.example.nutritionapp.home.presentation

import androidx.lifecycle.viewModelScope
import com.example.nutritionapp.base.domain.handle
import com.example.nutritionapp.base.presentation.BaseViewModel
import com.example.nutritionapp.diary.domain.GetDiaryUseCase
import com.example.nutritionapp.home.presentation.model.HomeEffect
import com.example.nutritionapp.home.presentation.model.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getDiaryUseCase: GetDiaryUseCase) :
    BaseViewModel<HomeState, HomeEffect>(
        HomeState()
    ) {
    init {
        getUserDiary()
    }

    fun getUserDiary() = viewModelScope.launch {
        getDiaryUseCase().handle(
            onSuccess = { diary -> updateState { it.copy(mealList = diary.mealList) } },
            onNotSuccess = {}
        )
    }
}