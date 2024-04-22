package com.example.nutritionapp.nutritionist.data.remote

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.diary.data.remote.model.DiaryDto
import com.example.nutritionapp.nutritionist.data.remote.model.AcceptDeclineDto
import com.example.nutritionapp.nutritionist.data.remote.model.InviteDto
import com.example.nutritionapp.nutritionist.data.remote.model.NutritionistDto
import com.example.nutritionapp.nutritionist.data.remote.model.PatientDto
import com.example.nutritionapp.nutritionist.data.remote.model.StatusDto
import com.example.nutritionapp.nutritionist.data.remote.model.UpdateDescriptionDto
import retrofit2.http.GET
import retrofit2.http.POST

interface NutritionistApi {
    @POST("nutritionist/invite")
    suspend fun inviteNutritionist(inviteDto: InviteDto): WorkResult<StatusDto>
    @POST("nutritionist/accept_decline")
    suspend fun acceptDeclineInvite(acceptDeclineDto: AcceptDeclineDto): WorkResult<StatusDto>
    @POST("nutritionist/update_desc")
    suspend fun updateDoctorsDescription(updateDescriptionDto: UpdateDescriptionDto): WorkResult<NutritionistDto>
    @GET("nutritionist/all")
    suspend fun getAllNutritionists(): WorkResult<List<NutritionistDto>>
    @GET("nutritionist/patients")
    suspend fun getPatients(): WorkResult<List<PatientDto>>
    @GET("nutritionist/diaries")
    suspend fun getPatientsDiaries(): WorkResult<List<DiaryDto>>
}