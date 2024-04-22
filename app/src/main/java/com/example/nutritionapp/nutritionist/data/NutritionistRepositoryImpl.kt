package com.example.nutritionapp.nutritionist.data

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.base.domain.map
import com.example.nutritionapp.diary.domain.model.Diary
import com.example.nutritionapp.nutritionist.data.remote.NutritionistApi
import com.example.nutritionapp.nutritionist.data.remote.model.InviteDto
import com.example.nutritionapp.nutritionist.data.remote.model.UpdateDescriptionDto
import com.example.nutritionapp.nutritionist.domain.model.AcceptDeclineStatus
import com.example.nutritionapp.nutritionist.domain.model.Nutritionist
import com.example.nutritionapp.nutritionist.domain.model.Patient
import com.example.nutritionapp.nutritionist.domain.model.Status
import com.example.nutritionapp.nutritionist.domain.repository.NutritionistRepository
import javax.inject.Inject

class NutritionistRepositoryImpl @Inject constructor(private val nutritionistApi: NutritionistApi) :
    NutritionistRepository {
    override suspend fun acceptDeclineInvite(acceptDeclineStatus: AcceptDeclineStatus): WorkResult<Status> {
        return nutritionistApi.acceptDeclineInvite(acceptDeclineStatus.fromDomain())
            .map { it.toDomain() }
    }

    override suspend fun getAllNutritionists(): WorkResult<List<Nutritionist>> {
        return nutritionistApi.getAllNutritionists().map { it.map { it.toDomain() } }
    }

    override suspend fun getPatients(): WorkResult<List<Patient>> {
        return nutritionistApi.getPatients().map { it.map { it.toDomain() } }
    }

    override suspend fun getPatientsDiaries(): WorkResult<List<Diary>> {
        return nutritionistApi.getPatientsDiaries().map { it.map { it.toDomain() } }
    }

    override suspend fun inviteDoctor(doctorId: Int): WorkResult<Status> {
        return nutritionistApi.inviteNutritionist(InviteDto(doctorId)).map { it.toDomain() }
    }

    override suspend fun updateDoctorDescription(newDesc: String): WorkResult<Nutritionist> {
        return nutritionistApi.updateDoctorsDescription(UpdateDescriptionDto(newDesc))
            .map { it.toDomain() }
    }
}