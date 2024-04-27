package com.example.nutritionapp.home.presentation.adapter

import android.util.Log
import com.example.nutritionapp.R
import com.example.nutritionapp.base.presentation.BaseViewHolder
import com.example.nutritionapp.base.utils.countCalories
import com.example.nutritionapp.databinding.MealCardBinding
import com.example.nutritionapp.meal.domain.model.Meal

class DiaryHolder(private val binding: MealCardBinding, private val clickCallBack: (Int) -> Unit) :
    BaseViewHolder(binding) {
    fun bind(data: Meal) = with(binding) {
        mainText.name.text = data.name
        mainText.quantity.text =
            binding.root.context.getString(R.string.calories, data.countCalories().toString())
        mainText.date.text = data.date
        root.setOnClickListener {
            Log.d("My Log", data.id.toString())
            clickCallBack.invoke(data.id)
        }
    }
}