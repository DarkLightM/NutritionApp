package com.example.nutritionapp.home.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nutritionapp.base.presentation.BaseViewHolder
import com.example.nutritionapp.databinding.MealCardBinding
import com.example.nutritionapp.meal.domain.model.Meal

class DiaryAdapter(
    private val clickCallBack: (Int) -> Unit
) : RecyclerView.Adapter<BaseViewHolder>() {
    private val oldList = mutableListOf<Meal>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return DiaryHolder(
            MealCardBinding.inflate(
                layoutInflater,
                parent, false
            )
        ) { clickCallBack.invoke(it) }
    }

    override fun getItemCount() = oldList.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is DiaryHolder -> {
                holder.bind(oldList[position])
            }
        }
    }

    fun submitList(newList: List<Meal>) {
        val diffCallback = DiaryDiffUtil(oldList, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        oldList.clear()
        oldList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }
}