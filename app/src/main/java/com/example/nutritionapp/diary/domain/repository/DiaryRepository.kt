package com.example.nutritionapp.diary.domain.repository

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.diary.domain.model.Diary

interface DiaryRepository {
    suspend fun getDiary(): WorkResult<Diary>
}