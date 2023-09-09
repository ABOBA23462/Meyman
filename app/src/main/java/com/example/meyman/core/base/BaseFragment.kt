package com.example.meyman.core.base

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.example.meyman.presentation.state.UIState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    abstract val binding: VB
    abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        setupRequests()
        setupSubscribes()
    }

    protected fun <T> StateFlow<UIState<T>>.collectState(
        state: (UIState<T>) -> Unit,
        onSuccess: (data: T) -> Unit
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                this@collectState.collect { result ->
                    state.invoke(result)
                    when (result) {
                        is UIState.Error -> {
                            //progressBar.gone()
                            Toast.makeText(requireContext(), result.error, Toast.LENGTH_SHORT)
                                .show()
                        }

                        is UIState.Loading -> {
                            //progressBar.visible()
                        }

                        is UIState.Success -> {
                            onSuccess(result.data)
                        }

                        is UIState.Empty -> {

                        }
                    }
                }
            }
        }
    }


    protected open fun initialize() {}

    protected open fun setupListener() {}

    protected open fun setupRequests() {}

    protected open fun setupSubscribes() {}
}