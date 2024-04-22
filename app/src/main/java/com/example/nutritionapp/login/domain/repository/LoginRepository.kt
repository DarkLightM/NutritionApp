package com.example.nutritionapp.login.domain.repository

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.login.data.remote.model.AuthDto
import com.example.nutritionapp.login.data.remote.model.AuthDtoResult
import com.example.nutritionapp.login.data.remote.model.RegisterDto
import com.example.nutritionapp.login.data.remote.model.RegisterDtoResult

interface LoginRepository {
    suspend fun register(registerDto: RegisterDto): WorkResult<RegisterDtoResult>
    suspend fun login(authDto: AuthDto): WorkResult<AuthDtoResult>
}