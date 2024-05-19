package com.example.nutritionapp.meal.presentation

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.nutritionapp.R
import com.example.nutritionapp.base.presentation.BaseFragment
import com.example.nutritionapp.base.utils.navigateUp
import com.example.nutritionapp.databinding.FragmentMealBinding
import com.example.nutritionapp.meal.presentation.model.MealEffect
import com.example.nutritionapp.meal.presentation.model.MealState
import com.example.nutritionapp.nutrition.domain.model.Nutrition
import com.example.nutritionapp.nutrition.presentation.adapter.NutritionAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MealFragment : BaseFragment<MealState, MealEffect>(R.layout.fragment_meal) {
    private val binding by viewBinding(FragmentMealBinding::bind)
    override val viewModel by viewModels<MealViewModel>()

    private val adapter by lazy {
        NutritionAdapter(isEditable = true) {
            viewModel.updateNutrition(it)
        }
    }

    override fun setupView() {
        arguments?.let {
            val mealId = it.getInt("parameter")
            viewModel.loadMeal(mealId)
        }
    }

    override fun setupListeners() = with(binding) {
        delete.setOnClickListener {
            viewModel.deleteMeal()
        }
        backArrow.setOnClickListener {
            navigateUp()
        }
    }

    override fun renderState(state: MealState) = with(binding) {
        mealName.text = getString(R.string.nutrition, state.name)
        setupAdapter(state.food)
    }

    private fun setupAdapter(list: List<Nutrition>) = with(binding) {
        adapter.submitList(list)
        mealRecycler.adapter = adapter
    }

    override fun reactToSideEffect(effect: MealEffect) {
        when (effect) {
            MealEffect.DeleteMealSuccess -> navigateUp()
        }
    }


}