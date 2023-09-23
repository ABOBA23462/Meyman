package com.example.meyman.presentation.ui.screens.forgot_password.updatePassword

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.meyman.R
import com.example.meyman.data.remote.dtos.auth.reset_password.PasswordDto
import com.example.meyman.databinding.FragmentUpdatePasswordBinding
import com.example.meyman.presentation.base.Resource
import com.example.meyman.presentation.ui.screens.forgot_password.ForgotPasswordFragmentDirections
import com.example.meyman.presentation.ui.screens.room_page.RoomPageFragmentArgs
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UpdatePasswordFragment : Fragment() {

    private lateinit var binding: FragmentUpdatePasswordBinding
    private val viewModel: UpdatePasswordViewModel by viewModels()
    private val args: UpdatePasswordFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdatePasswordBinding.inflate(inflater, container, false)
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
            val password = etPassword.text.toString()
            val model = PasswordDto(password)
            val confirmPassword = etConfirmPassword.text.toString()
            if (confirmPassword == password) {
                viewLifecycleOwner.lifecycleScope.launch {
                    viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                        viewModel.getPassword(args.code, model).collect {
                            when (it) {
                                is Resource.Loading -> {
                                }

                                is Resource.Error -> {
                                    Log.e("ololo", "setupSubscribes11111: " + it.message)
                                }

                                is Resource.Success -> {
                                    Toast.makeText(requireContext(), "Huynia", Toast.LENGTH_SHORT)
                                        .show()
                                }
                            }
                        }
                    }
                }
            } else {
                Toast.makeText(requireContext(), "Blia", Toast.LENGTH_SHORT).show()
            }
        }
    }
}