package com.example.nutritionapp.nutritionist.di

import com.example.nutritionapp.nutritionist.data.NutritionistRepositoryImpl
import com.example.nutritionapp.nutritionist.data.remote.NutritionistApi
import com.example.nutritionapp.nutritionist.domain.repository.NutritionistRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NutritionistModule.NutritionistBindsModule::class])
@InstallIn(SingletonComponent::class)
object NutritionistModule {
    @Provides
    @Singleton
    fun provideNutritionistApi(retrofit: Retrofit): NutritionistApi {
        return retrofit.create(NutritionistApi::class.java)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface NutritionistBindsModule {
        @Binds
        fun bindNutritionistModule(impl: NutritionistRepositoryImpl): NutritionistRepository
    }
}