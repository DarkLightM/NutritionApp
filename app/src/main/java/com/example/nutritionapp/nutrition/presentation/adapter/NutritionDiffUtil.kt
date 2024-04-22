package com.example.nutritionapp.nutrition.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.nutritionapp.nutrition.domain.model.Nutrition

class NutritionDiffUtil (
    private val oldList: List<Nutrition>,
    private val newList: List<Nutrition>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == newList[newItemPosition].name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}
