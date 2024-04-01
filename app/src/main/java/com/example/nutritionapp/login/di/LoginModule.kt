package com.example.nutritionapp.login.di

import com.example.nutritionapp.login.data.LoginRepositoryImpl
import com.example.nutritionapp.login.data.remote.LoginApi
import com.example.nutritionapp.login.domain.repository.LoginRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [LoginModule.LoginBindsModule::class])
@InstallIn(SingletonComponent::class)
object LoginModule {
    @Provides
    @Singleton
    fun provideLoginApi(retrofit: Retrofit): LoginApi {
        return retrofit.create(LoginApi::class.java)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface LoginBindsModule {
        @Binds
        fun bindLoginRepository(impl: LoginRepositoryImpl): LoginRepository
    }
}