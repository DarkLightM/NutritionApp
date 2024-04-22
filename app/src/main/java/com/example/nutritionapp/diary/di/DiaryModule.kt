package com.example.nutritionapp.diary.di

import com.example.nutritionapp.diary.data.DiaryRepositoryImpl
import com.example.nutritionapp.diary.data.remote.DiaryApi
import com.example.nutritionapp.diary.domain.repository.DiaryRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [DiaryModule.DiaryBindsModule::class])
@InstallIn(SingletonComponent::class)
object DiaryModule {
    @Provides
    @Singleton
    fun provideDiaryApi(retrofit: Retrofit): DiaryApi {
        return retrofit.create(DiaryApi::class.java)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface DiaryBindsModule {
        @Binds
        fun bindDiaryRepository(impl: DiaryRepositoryImpl): DiaryRepository
    }
}