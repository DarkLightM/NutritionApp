package com.example.nutritionapp.nutrition.data

import com.example.nutritionapp.nutrition.data.remote.NutritionApi
import com.example.nutritionapp.nutrition.domain.model.Nutrition
import com.example.nutritionapp.nutrition.domain.repository.NutritionRepository
import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.base.domain.map
import javax.inject.Inject

class NutritionRepositoryImpl @Inject constructor(private val nutritionApi: NutritionApi) :
    NutritionRepository {
    override suspend fun getNutrition(query: String): WorkResult<List<Nutrition>> {
        return nutritionApi.getNutrition(query).map {it.map { it.toDomain() }}
    }
}