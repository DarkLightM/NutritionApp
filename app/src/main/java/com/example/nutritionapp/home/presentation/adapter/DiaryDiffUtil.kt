package com.example.nutritionapp.home.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.nutritionapp.meal.domain.model.Meal

class DiaryDiffUtil(
    private val oldList: List<Meal>,
    private val newList: List<Meal>
) : DiffUtil.Callback(){
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}