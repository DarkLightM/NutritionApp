package com.example.nutritionapp.meal.data.remote

import com.example.nutritionapp.base.data.remote.model.OperationModel
import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.meal.data.remote.model.MealDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path

interface MealApi {
    @POST("meal/insert")
    suspend fun insertMeal(@Body mealDto: MealDto, @Header("token") token: String): WorkResult<MealDto>

    @DELETE("meal/{id}/delete")
    suspend fun deleteMeal(@Path("id") id: Int, @Header("token") token: String): WorkResult<OperationModel>
}