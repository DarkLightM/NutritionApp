package com.example.nutritionapp.diary.data

import android.content.SharedPreferences
import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.base.domain.map
import com.example.nutritionapp.diary.data.remote.DiaryApi
import com.example.nutritionapp.diary.domain.model.Diary
import com.example.nutritionapp.diary.domain.repository.DiaryRepository
import com.example.nutritionapp.sharedprefs.model.SharedPrefs
import com.example.nutritionapp.sharedprefs.model.SharedPrefsType
import com.example.nutritionapp.sharedprefs.utils.getToken
import javax.inject.Inject

class DiaryRepositoryImpl @Inject constructor(
    @SharedPrefs(SharedPrefsType.DEFAULT)
    private val sharedPreferences: SharedPreferences, private val diaryApi: DiaryApi
) : DiaryRepository {
    private val token = sharedPreferences.getToken()
    override suspend fun getDiary(): WorkResult<Diary> {
        return diaryApi.getDiary(token).map { it.toDomain() }
    }
}