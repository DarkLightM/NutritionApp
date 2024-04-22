package com.example.nutritionapp.diary.data.remote.model

import com.example.nutritionapp.diary.domain.model.Diary
import com.example.nutritionapp.meal.data.remote.model.MealDto
import com.google.gson.annotations.SerializedName

data class DiaryDto(
    @SerializedName("user_id")
    val userId: Int,
    @SerializedName("user_name")
    val userName: String,
    @SerializedName("meal_list")
    val mealList: List<MealDto>
) {
    fun toDomain(): Diary {
        return Diary(userId, userName, mealList.map { it.toDomain() })
    }
}
