package com.example.nutritionapp.profile.presentation

import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.nutritionapp.base.presentation.BaseViewModel
import com.example.nutritionapp.profile.presentation.model.SettingsEffect
import com.example.nutritionapp.profile.presentation.model.SettingsState
import com.example.nutritionapp.sharedprefs.model.SharedPrefs
import com.example.nutritionapp.sharedprefs.model.SharedPrefsType
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    @SharedPrefs(SharedPrefsType.DEFAULT) private val sharedPreferences: SharedPreferences) :
    BaseViewModel<SettingsState, SettingsEffect>(SettingsState()) {
    fun exit() {
        sharedPreferences.edit { putString("token", "") }
    }
}