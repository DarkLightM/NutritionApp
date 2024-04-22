package com.example.nutritionapp.meal.di

import com.example.nutritionapp.meal.data.MealRepositoryImpl
import com.example.nutritionapp.meal.data.remote.MealApi
import com.example.nutritionapp.meal.domain.repository.MealRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [MealModule.MealBindsModule::class])
@InstallIn(SingletonComponent::class)
object MealModule {
    @Provides
    @Singleton
    fun provideMealApi(retrofit: Retrofit): MealApi {
        return retrofit.create(MealApi::class.java)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface MealBindsModule {
        @Binds
        fun bindMealModule(impl: MealRepositoryImpl): MealRepository
    }
}