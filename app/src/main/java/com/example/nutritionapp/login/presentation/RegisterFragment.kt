package com.example.nutritionapp.login.presentation

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.nutritionapp.R
import com.example.nutritionapp.base.presentation.BaseFragment
import com.example.nutritionapp.base.utils.navigateUp
import com.example.nutritionapp.databinding.FragmentRegisterBinding
import com.example.nutritionapp.login.presentation.model.RegisterEffect
import com.example.nutritionapp.login.presentation.model.RegisterState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterFragment : BaseFragment<RegisterState, RegisterEffect>(R.layout.fragment_register) {
    private val binding by viewBinding(FragmentRegisterBinding::bind)
    override val viewModel by viewModels<RegisterViewModel>()

    override fun setupListeners() = with(binding) {
        register.setOnClickListener {
            viewModel.register(
                username.toString(),
                email.toString(),
                password.toString(),
                if (isDoctor.isChecked) "d" else "p"
            )
        }
    }

    override fun reactToSideEffect(effect: RegisterEffect) {
        when (effect) {
            is RegisterEffect.RegisterSuccess -> navigateUp()
            is RegisterEffect.RegisterFail -> {}
        }
    }
}