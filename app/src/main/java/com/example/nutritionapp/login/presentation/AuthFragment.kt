package com.example.nutritionapp.login.presentation

import android.widget.Toast
import com.example.nutritionapp.R
import com.example.nutritionapp.base.presentation.BaseFragment
import com.example.nutritionapp.login.presentation.model.AuthEffect
import com.example.nutritionapp.login.presentation.model.AuthState
import dagger.hilt.android.AndroidEntryPoint
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.nutritionapp.base.utils.navigate
import com.example.nutritionapp.databinding.FragmentAuthBinding

@AndroidEntryPoint
class AuthFragment : BaseFragment<AuthState, AuthEffect>(R.layout.fragment_auth) {
    private val binding by viewBinding(FragmentAuthBinding::bind)
    override val viewModel by viewModels<AuthViewModel>()

    override fun setupListeners() = with(binding){
        login.setOnClickListener{
            viewModel.auth(email.text.toString(), password.text.toString())
        }
        register.setOnClickListener {
            navigate(R.id.registerFragment)
        }
    }

    override fun reactToSideEffect(effect: AuthEffect) {
        when (effect){
            is AuthEffect.AuthSuccess -> navigate(R.id.homeFragment)
            is AuthEffect.AuthFail -> {
                Toast.makeText(requireContext(), "Ошибка при входе", Toast.LENGTH_SHORT).show()}
        }
    }
}