package com.example.nutritionapp.login.data.remote

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.login.data.remote.model.AuthDto
import com.example.nutritionapp.login.data.remote.model.AuthDtoResult
import com.example.nutritionapp.login.data.remote.model.RegisterDto
import com.example.nutritionapp.login.data.remote.model.RegisterDtoResult
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST("register")
    suspend fun register(@Body registerDto: RegisterDto): WorkResult<RegisterDtoResult>

    @POST("login")
    suspend fun login(@Body authDto: AuthDto): WorkResult<AuthDtoResult>
}