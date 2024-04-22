package com.example.nutritionapp.meal.data

import android.content.SharedPreferences
import com.example.nutritionapp.base.data.remote.model.OperationModel
import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.base.domain.map
import com.example.nutritionapp.meal.data.remote.MealApi
import com.example.nutritionapp.meal.domain.model.Meal
import com.example.nutritionapp.meal.domain.repository.MealRepository
import com.example.nutritionapp.sharedprefs.model.SharedPrefs
import com.example.nutritionapp.sharedprefs.model.SharedPrefsType
import com.example.nutritionapp.sharedprefs.utils.getToken
import javax.inject.Inject

class MealRepositoryImpl @Inject constructor(
    @SharedPrefs(SharedPrefsType.DEFAULT)
    private val sharedPreferences: SharedPreferences, private val mealApi: MealApi
) : MealRepository {
    private val token = sharedPreferences.getToken()
    override suspend fun insertMeal(meal: Meal): WorkResult<Meal> {
        return mealApi.insertMeal(meal.fromDomain(), token)
            .map { it.toDomain() }
    }

    override suspend fun deleteMeal(id: Int): WorkResult<OperationModel> {
        return mealApi.deleteMeal(id, token)
    }
}