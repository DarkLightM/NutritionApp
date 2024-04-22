package com.example.nutritionapp.nutrition.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.nutritionapp.base.presentation.BaseViewHolder
import com.example.nutritionapp.databinding.CardProductBinding
import com.example.nutritionapp.nutrition.domain.model.Nutrition

class NutritionAdapter(
    private val clickCallBack: (CallBackAdapterEvent) -> Unit
) : RecyclerView.Adapter<BaseViewHolder>() {
    private val oldList = mutableListOf<Nutrition>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NutritionHolder(
            CardProductBinding.inflate(
                layoutInflater,
                parent, false
            )
        ) {
            clickCallBack.invoke(it)
        }
    }

    override fun getItemCount() = oldList.size

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        when (holder) {
            is NutritionHolder -> {
                holder.bind(oldList[position])
            }
        }
    }

    fun submitList(newList: List<Nutrition>) {
        val diffCallback = NutritionDiffUtil(oldList, newList)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        oldList.clear()
        oldList.addAll(newList)
        diffResult.dispatchUpdatesTo(this)
    }


}