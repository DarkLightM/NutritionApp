package com.example.nutritionapp.profile.presentation

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.nutritionapp.R
import com.example.nutritionapp.base.presentation.BaseFragment
import com.example.nutritionapp.base.utils.navigate
import com.example.nutritionapp.databinding.FragmentProfileBinding
import com.example.nutritionapp.profile.presentation.model.SettingsEffect
import com.example.nutritionapp.profile.presentation.model.SettingsState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : BaseFragment<SettingsState, SettingsEffect>(R.layout.fragment_profile) {
    private val binding by viewBinding(FragmentProfileBinding::bind)
    override val viewModel by viewModels<SettingsViewModel>()

    override fun setupListeners() = with(binding) {
        exit.setOnClickListener {
            viewModel.exit()
            findNavController().popBackStack(R.id.settingsFragment, true)
            navigate(R.id.authFragment)
        }
    }

}