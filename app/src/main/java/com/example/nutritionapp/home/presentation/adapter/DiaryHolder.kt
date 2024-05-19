package com.example.nutritionapp.home.presentation.adapter

import com.example.nutritionapp.R
import com.example.nutritionapp.base.presentation.BaseViewHolder
import com.example.nutritionapp.base.utils.countCalories
import com.example.nutritionapp.databinding.MealCardBinding
import com.example.nutritionapp.meal.domain.model.Meal
import java.util.Locale

class DiaryHolder(private val binding: MealCardBinding, private val clickCallBack: (Int) -> Unit) :
    BaseViewHolder(binding) {
    fun bind(data: Meal) = with(binding) {
        mainText.name.text = data.name.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }
        mainText.quantity.text =
            binding.root.context.getString(R.string.calories, data.countCalories())
        mainText.date.text = data.date
        root.setOnClickListener {
            clickCallBack.invoke(data.id)
        }
    }
}