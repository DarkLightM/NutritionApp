package com.example.nutritionapp.diary.data.remote

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.diary.data.remote.model.DiaryDto
import retrofit2.http.GET
import retrofit2.http.Header

interface DiaryApi {
    @GET("diary")
    suspend fun getDiary(@Header("token") token: String): WorkResult<DiaryDto>
}