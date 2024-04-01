package com.example.nutritionapp.login.data

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.login.data.remote.LoginApi
import com.example.nutritionapp.login.data.remote.model.AuthDtoResult
import com.example.nutritionapp.login.data.remote.model.RegisterDto
import com.example.nutritionapp.login.data.remote.model.RegisterDtoResult
import com.example.nutritionapp.login.domain.repository.LoginRepository
import okhttp3.RequestBody.Companion.toRequestBody
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val loginApi: LoginApi) : LoginRepository {
    override suspend fun register(registerDto: RegisterDto): WorkResult<RegisterDtoResult> {
        return loginApi.register(registerDto)
    }

    override suspend fun login(username: String, password: String): WorkResult<AuthDtoResult> {
        return loginApi.login(username.toRequestBody(), password.toRequestBody())
    }
}