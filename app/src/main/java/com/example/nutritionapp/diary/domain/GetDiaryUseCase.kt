package com.example.nutritionapp.diary.domain

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.diary.domain.model.Diary
import com.example.nutritionapp.diary.domain.repository.DiaryRepository
import javax.inject.Inject

class GetDiaryUseCase @Inject constructor(private val diaryRepository: DiaryRepository) {
    suspend operator fun invoke(): WorkResult<Diary> {
        return diaryRepository.getDiary()
    }
}