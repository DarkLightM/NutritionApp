package com.example.nutritionapp.nutrition.data.remote

import com.example.nutritionapp.nutrition.data.remote.model.NutritionDto
import com.example.nutritionapp.base.domain.WorkResult
import retrofit2.http.GET
import retrofit2.http.Query

interface NutritionApi {
    @GET("nutrition/get_nutrition")
    suspend fun getNutrition(@Query("query") query: String): WorkResult<List<NutritionDto>>
}