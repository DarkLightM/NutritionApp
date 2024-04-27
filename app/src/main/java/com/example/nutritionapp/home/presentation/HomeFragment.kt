package com.example.nutritionapp.home.presentation

import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.nutritionapp.R
import com.example.nutritionapp.base.presentation.BaseFragment
import com.example.nutritionapp.base.utils.navigate
import com.example.nutritionapp.databinding.FragmentHomeBinding
import com.example.nutritionapp.home.presentation.adapter.DiaryAdapter
import com.example.nutritionapp.home.presentation.model.HomeEffect
import com.example.nutritionapp.home.presentation.model.HomeState
import com.example.nutritionapp.meal.domain.model.Meal
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<HomeState, HomeEffect>(R.layout.fragment_home) {
    private val binding by viewBinding(FragmentHomeBinding::bind)
    override val viewModel by viewModels<HomeViewModel>()

    private val adapter by lazy {
        DiaryAdapter { mealId ->
            val args = bundleOf("parameter" to mealId)
            navigate(R.id.mealFragment, args)
        }
    }

    override fun renderState(state: HomeState) {
        setupAdapter(state.mealList)
    }

    private fun setupAdapter(list: List<Meal>) = with(binding) {
        adapter.submitList(list)
        mealList.adapter = adapter
    }
}