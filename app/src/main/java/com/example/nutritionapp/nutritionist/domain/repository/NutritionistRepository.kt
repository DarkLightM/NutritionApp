package com.example.nutritionapp.nutritionist.domain.repository

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.diary.domain.model.Diary
import com.example.nutritionapp.nutritionist.domain.model.AcceptDeclineStatus
import com.example.nutritionapp.nutritionist.domain.model.Nutritionist
import com.example.nutritionapp.nutritionist.domain.model.Patient
import com.example.nutritionapp.nutritionist.domain.model.Status

interface NutritionistRepository {
    suspend fun acceptDeclineInvite(acceptDeclineStatus: AcceptDeclineStatus): WorkResult<Status>
    suspend fun getAllNutritionists(): WorkResult<List<Nutritionist>>
    suspend fun getPatients(): WorkResult<List<Patient>>
    suspend fun getPatientsDiaries(): WorkResult<List<Diary>>
    suspend fun inviteDoctor(doctorId: Int): WorkResult<Status>
    suspend fun updateDoctorDescription(newDesc: String): WorkResult<Nutritionist>
}