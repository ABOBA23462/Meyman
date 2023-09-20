package com.example.meyman.presentation.ui.screens.forgot_password.acceptCode

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.meyman.R
import com.example.meyman.data.remote.dtos.auth.reset_password.CodeDto
import com.example.meyman.databinding.FragmentAcceptCodeBinding
import com.example.meyman.presentation.base.Resource
import com.example.meyman.presentation.ui.screens.forgot_password.ForgotPasswordFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AcceptCodeFragment : Fragment() {

    private lateinit var binding: FragmentAcceptCodeBinding
    private val viewModel: AcceptCodeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAcceptCodeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
forgotPassword()


        binding.ivBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun forgotPassword() = with(binding) {

        btnAccept.setOnClickListener {
            val code = etCode.text.toString().trim()
            val model = CodeDto(code)
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.getCode(model).collect {
                        when (it) {
                            is Resource.Loading -> {
                            }

                            is Resource.Error -> {
                                Log.e("ololo", "setupSubscribes11111: " + it.message)
                            }

                            is Resource.Success -> {
                                findNavController().navigate(R.id.action_acceptCodeFragment_to_updatePasswordFragment2)
                            }
                        }
                    }
                }
            }
        }
    }
}