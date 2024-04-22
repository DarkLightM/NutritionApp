package com.example.nutritionapp.nutrition.presentation.adapter

import com.example.nutritionapp.nutrition.domain.model.Nutrition

sealed class CallBackAdapterEvent {
    class Open(val nutrition: Nutrition): CallBackAdapterEvent()
    class Plus(val name: String): CallBackAdapterEvent()
    class Minus(val name: String): CallBackAdapterEvent()
}