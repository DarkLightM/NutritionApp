package com.example.nutritionapp.login.domain

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.login.data.remote.model.RegisterDto
import com.example.nutritionapp.login.data.remote.model.RegisterDtoResult
import com.example.nutritionapp.login.domain.repository.LoginRepository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val loginRepository: LoginRepository) {
    suspend operator fun invoke(registerDto: RegisterDto) : WorkResult<RegisterDtoResult> {
        return loginRepository.register(registerDto)
    }
}