package com.example.nutritionapp.nutrition.data.remote

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.nutrition.data.remote.model.NutritionDto
import com.example.nutritionapp.nutrition.data.remote.model.UpdateNutritionDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.PUT
import retrofit2.http.Query

interface NutritionApi {
    @GET("nutrition/get")
    suspend fun getNutrition(
        @Query("query") query: String,
        @Header("token") token: String
    ): WorkResult<List<NutritionDto>>

    @PUT("nutrition/update")
    suspend fun updateNutrition(
        @Body updateNutritionDto: UpdateNutritionDto,
        @Header("token") token: String
    ): WorkResult<NutritionDto>
}