package com.example.nutritionapp.login.domain

import com.example.nutritionapp.base.domain.WorkResult
import com.example.nutritionapp.login.data.remote.model.AuthDto
import com.example.nutritionapp.login.data.remote.model.AuthDtoResult
import com.example.nutritionapp.login.domain.repository.LoginRepository
import javax.inject.Inject

class AuthUseCase @Inject constructor(private val loginRepository: LoginRepository) {
    suspend operator fun invoke(authDto: AuthDto): WorkResult<AuthDtoResult> {
        return loginRepository.login(authDto)
    }
}