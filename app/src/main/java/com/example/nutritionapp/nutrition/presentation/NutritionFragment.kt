package com.example.nutritionapp.nutrition.presentation

import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.nutritionapp.R
import com.example.nutritionapp.base.presentation.BaseFragment
import com.example.nutritionapp.base.utils.navigate
import com.example.nutritionapp.databinding.FragmentNutritionBinding
import com.example.nutritionapp.nutrition.domain.model.Nutrition
import com.example.nutritionapp.nutrition.presentation.adapter.NutritionAdapter
import com.example.nutritionapp.nutrition.presentation.model.NutritionEffect
import com.example.nutritionapp.nutrition.presentation.model.NutritionState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NutritionFragment :
    BaseFragment<NutritionState, NutritionEffect>(R.layout.fragment_nutrition) {

    private val binding by viewBinding(FragmentNutritionBinding::bind)
    override val viewModel by viewModels<NutritionViewModel>()

    private val adapter by lazy {
        NutritionAdapter {
            viewModel.handleNutritionEvents(it)
        }
    }

    override fun setupView() = with(binding) {
        val layoutManager = GridLayoutManager(requireContext(), 2)
        nutrition.layoutManager = layoutManager
    }


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
        setupAdapter(state.nutrition)
    }

    override fun reactToSideEffect(effect: NutritionEffect) {
        when (effect) {
            is NutritionEffect.NutritionLoadFailed -> {}
            is NutritionEffect.OpenNutrition -> {
                navigate(R.id.nutritionInfoFragment)
            }
        }
    }

    private fun setupAdapter(list: List<Nutrition>) = with(binding) {
        adapter.submitList(list)
        nutrition.adapter = adapter
    }


}