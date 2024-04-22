package com.example.nutritionapp.nutrition.data

import android.content.SharedPreferences
import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.base.domain.map
import com.example.nutritionapp.nutrition.data.remote.NutritionApi
import com.example.nutritionapp.nutrition.domain.model.Nutrition
import com.example.nutritionapp.nutrition.domain.model.UpdateNutrition
import com.example.nutritionapp.nutrition.domain.repository.NutritionRepository
import com.example.nutritionapp.sharedprefs.model.SharedPrefs
import com.example.nutritionapp.sharedprefs.model.SharedPrefsType
import com.example.nutritionapp.sharedprefs.utils.getToken
import javax.inject.Inject

class NutritionRepositoryImpl @Inject constructor(
    @SharedPrefs(SharedPrefsType.DEFAULT)
    private val sharedPreferences: SharedPreferences,
    private val nutritionApi: NutritionApi
) :
    NutritionRepository {
    private val token = sharedPreferences.getToken()
    override suspend fun getNutrition(query: String): WorkResult<List<Nutrition>> {
        return nutritionApi.getNutrition(query).map { it.map { it.toDomain() } }
    }

    override suspend fun updateNutrition(updateNutrition: UpdateNutrition): WorkResult<Nutrition> {
        return nutritionApi.updateNutrition(
            updateNutrition.fromDomain(),
            token
        ).map { it.toDomain() }
    }
}