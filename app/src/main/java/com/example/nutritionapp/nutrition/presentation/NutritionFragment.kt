package com.example.nutritionapp.nutrition.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.nutritionapp.R
import com.example.nutritionapp.base.presentation.BaseFragment
import com.example.nutritionapp.databinding.FragmentNutritionBinding
import com.example.nutritionapp.nutrition.presentation.model.NutritionEffect
import com.example.nutritionapp.nutrition.presentation.model.NutritionState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NutritionFragment :
    BaseFragment<NutritionState, NutritionEffect>(R.layout.fragment_nutrition) {

    private val binding by viewBinding(FragmentNutritionBinding::bind)
    override val viewModel by viewModels<NutritionViewModel>()

    override fun setupListeners() = with(binding) {
        search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (!query.isNullOrEmpty()) {
                    viewModel.getNutrition(query)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean = false
        })
    }

    override fun renderState(state: NutritionState) = with(binding) {
        result.text = state.nutrition.toString()
    }


}