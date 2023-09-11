package com.example.meyman.presentation.ui.screens.sign.`in`

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.meyman.R
import com.example.meyman.databinding.FragmentSignInBinding
import com.example.meyman.domain.utils.models.RegisterDomain
import com.example.meyman.presentation.base.Resource
import com.example.meyman.presentation.models.toUI
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignInFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentSignInBinding
    private val viewModel: SignInViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupSubscribes()

    }

    private fun setupSubscribes() = with(binding) {

        var signIn = true

        tvSignUp.setOnClickListener {
            signIn = false
            tvSignUp.setTextColor(ContextCompat.getColor(requireContext(), R.color.blue1))
            tvSignIn.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            tilEmail.visibility = View.GONE
            tilPassword.visibility = View.GONE
            tvForgotPassword.visibility = View.GONE
            tilRegEmail.visibility = View.VISIBLE
            tilRegUserName.visibility = View.VISIBLE
            tilConfirmPassword.visibility = View.VISIBLE
            tilRegPassword.visibility = View.VISIBLE
            btnRegister.visibility = View.VISIBLE
            btnSignIn.visibility = View.GONE
        }
        tvSignIn.setOnClickListener {
            signIn = true
            tvSignUp.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            tvSignIn.setTextColor(ContextCompat.getColor(requireContext(), R.color.blue1))
            tilEmail.visibility = View.VISIBLE
            tilPassword.visibility = View.VISIBLE
            tilRegEmail.visibility = View.GONE
            tilRegUserName.visibility = View.GONE
            tilConfirmPassword.visibility = View.GONE
            tilRegPassword.visibility = View.GONE
            tvForgotPassword.visibility = View.VISIBLE
        }

        btnRegister.setOnClickListener {
            val email = binding.etRegEmail.text.toString()
            val username = binding.etRegUserName.text.toString()
            val password = binding.etRegPassword.text.toString()
            val usertype = "client"
            Log.d("MyApp", "Email: $email, UserName: $username, Password: $password")
            val model = RegisterDomain(password, usertype, email, username)
            Log.d("qwerty", "$model")
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.getRegisterState(model).collect {
                        when (it) {
                            is Resource.Loading -> {

                            }

                            is Resource.Error -> {
                                Log.e("ololo", "setupSubscribes: " + it.message)

                            }

                            is Resource.Success -> {
                                val list = it.data?.toUI()
                                Log.e("MyApp", "setupSubscribes: $list")
                                findNavController().navigate(R.id.action_guestProfileFragment_to_connectFragment)
                            }
                        }
                    }
                }
            }
        }

        tvForgotPassword.setOnClickListener {
            // Реализовать переход в фрагмент изменения пароля
        }
    }
}