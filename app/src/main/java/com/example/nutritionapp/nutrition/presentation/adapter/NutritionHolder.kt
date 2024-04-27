package com.example.nutritionapp.nutrition.presentation.adapter

import android.content.Context
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import androidx.core.view.isVisible
import com.example.nutritionapp.base.presentation.BaseViewHolder
import com.example.nutritionapp.base.utils.toList
import com.example.nutritionapp.databinding.CardProductBinding
import com.example.nutritionapp.nutrition.domain.model.Nutrition
import com.example.nutritionapp.nutrition.domain.model.UpdateNutrition

class NutritionHolder(
    private val binding: CardProductBinding,
    private val isEditable: Boolean,
    private val clickCallBack: (UpdateNutrition) -> Unit
) : BaseViewHolder(binding) {
    fun bind(data: Nutrition) = with(binding) {
        name.text = data.name
        nutrition.text = data.toList().joinToString("\n")
        editServingSize.isVisible = isEditable
        onEditorListener(data.id)
    }

    private fun onEditorListener(id: Int) = with(binding.root.context){
        binding.editServingSize.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                clickCallBack.invoke(UpdateNutrition(id, binding.editServingSize.text.toString()))
                val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                inputMethodManager.hideSoftInputFromWindow(binding.editServingSize.windowToken, 0)
                true
            } else {
                false
            }
        }

    }
}