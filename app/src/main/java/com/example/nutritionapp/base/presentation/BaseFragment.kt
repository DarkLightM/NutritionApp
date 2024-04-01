package com.example.nutritionapp.base.presentation

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.Flow

abstract class BaseFragment<S : UiState, E : UiEffect> (@LayoutRes layoutId: Int): Fragment(layoutId) {
    protected abstract val viewModel: BaseViewModel<S, E>

    protected open fun renderState(state: S) = Unit

    protected open fun reactToSideEffect(effect: E) = Unit

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupListeners()
        observeFlow(viewModel.state, ::renderState)
        observeFlow(viewModel.events, ::reactToSideEffect)
    }

    fun <T> Fragment.observeFlow(flow: Flow<T>, action: (T) -> Unit) {
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            flow.collect { action(it) }
        }
    }

    protected open fun setupListeners() = Unit

}