package com.example.nutritionapp.login.data.remote

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.login.data.remote.model.AuthDtoResult
import com.example.nutritionapp.login.data.remote.model.RegisterDto
import com.example.nutritionapp.login.data.remote.model.RegisterDtoResult
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.Part

interface LoginApi {
    @POST("register")
    suspend fun register(@Body registerDto: RegisterDto): WorkResult<RegisterDtoResult>

    @Multipart
    @POST("login")
    suspend fun login(
        @Part("username") email: RequestBody,
        @Part("password") password: RequestBody
    ): WorkResult<AuthDtoResult>
}