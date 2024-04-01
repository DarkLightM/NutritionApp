package com.example.nutritionapp.nutrition.di

import com.example.nutritionapp.nutrition.data.NutritionRepositoryImpl
import com.example.nutritionapp.nutrition.data.remote.NutritionApi
import com.example.nutritionapp.nutrition.domain.repository.NutritionRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [NutritionModule.NutritionBindsModule::class])
@InstallIn(SingletonComponent::class)
object NutritionModule {
    @Provides
    @Singleton
    fun provideNutritionApi(retrofit: Retrofit): NutritionApi {
        return retrofit.create(NutritionApi::class.java)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface NutritionBindsModule {
        @Binds
        fun bindNutritionRepository(impl: NutritionRepositoryImpl): NutritionRepository
    }
}