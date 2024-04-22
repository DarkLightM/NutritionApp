package com.example.nutritionapp.nutrition.presentation.adapter

import com.example.nutritionapp.R
import com.example.nutritionapp.base.presentation.BaseViewHolder
import com.example.nutritionapp.databinding.CardProductBinding
import com.example.nutritionapp.nutrition.domain.model.Nutrition

class NutritionHolder(
    private val binding: CardProductBinding,
    private val clickCallBack: (CallBackAdapterEvent) -> Unit
) : BaseViewHolder(binding) {
    fun bind(data: Nutrition) = with(binding) {
        name.text = data.name
        calories.text = binding.root.context.getString(R.string.calories, data.calories)
        mass.text = binding.root.context.getString(R.string.grams, data.servingSize)
        root.setOnClickListener {
            clickCallBack.invoke(CallBackAdapterEvent.Open(data))
        }
        minus.setOnClickListener {
            clickCallBack.invoke(CallBackAdapterEvent.Minus(data.name))
        }
        plus.setOnClickListener {
            clickCallBack.invoke(CallBackAdapterEvent.Plus(data.name))
        }
    }
}