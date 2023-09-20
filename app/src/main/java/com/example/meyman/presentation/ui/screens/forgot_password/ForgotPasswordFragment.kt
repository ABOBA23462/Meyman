package com.example.meyman.presentation.ui.screens.forgot_password

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
import com.example.meyman.data.remote.dtos.auth.reset_password.EmailDto
import com.example.meyman.databinding.FragmentForgotPasswordBinding
import com.example.meyman.presentation.base.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ForgotPasswordFragment : Fragment() {

    private lateinit var binding: FragmentForgotPasswordBinding
    private val viewModel: ForgotPasswordViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForgotPasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        forgotPassword()
//            findNavController().navigate(R.id.acceptCodeFragment)
    }

    private fun forgotPassword() = with(binding) {
        btnAccept.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val model = EmailDto(email)
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.getEmail(model).collect {
                        when (it) {
                            is Resource.Loading -> {
                            }

                            is Resource.Error -> {
                                Log.e("ololo", "setupSubscribes11111: " + it.message)
                            }

                            is Resource.Success -> {
                                Log.e("ololo", "setupSubscribes11111: " + it.data)
                                findNavController().navigate(
                                    ForgotPasswordFragmentDirections.actionForgotPasswordFragmentToAcceptCodeFragment(
                                        email
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }

}