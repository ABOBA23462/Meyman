package com.example.meyman.presentation.ui.screens.sign.`in`

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.meyman.R
import com.example.meyman.data.remote.dtos.auth.LoginDto
import com.example.meyman.data.remote.dtos.auth.RegisterDto
import com.example.meyman.data.remote.preferences.UserDataPreferencesHelper
import com.example.meyman.databinding.FragmentSignInBinding
import com.example.meyman.presentation.base.Resource
import com.example.meyman.presentation.models.auth.toUI
import com.example.meyman.presentation.ui.screens.sign.`in`.verifyAccount.VerifyAccountFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SignInFragment : BottomSheetDialogFragment() {

    @Inject
    lateinit var userPreferencesData: UserDataPreferencesHelper
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
        register()
        login()
    }

    @SuppressLint("ResourceType")
    private fun setupSubscribes() = with(binding) {

        var signIn = true

        tvSignUp.setOnClickListener {
            signIn = false
            tvSignUp.setTextColor(ContextCompat.getColor(requireContext(), R.color.blue1))
            tvSignIn.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            tilEmail.visibility = View.GONE
            tilPassword.visibility = View.GONE
            tvForgotPassword.visibility = View.GONE
            btnSignIn.visibility = View.GONE
            tilRegEmail.visibility = View.VISIBLE
            tilRegUserName.visibility = View.VISIBLE
            tilConfirmPassword.visibility = View.VISIBLE
            tilRegPassword.visibility = View.VISIBLE
            btnRegister.visibility = View.VISIBLE
        }
        tvSignIn.setOnClickListener {
            signIn = true
            tvSignUp.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            tvSignIn.setTextColor(ContextCompat.getColor(requireContext(), R.color.blue1))
            tilRegEmail.visibility = View.GONE
            tilRegUserName.visibility = View.GONE
            tilConfirmPassword.visibility = View.GONE
            tilRegPassword.visibility = View.GONE
            btnRegister.visibility = View.GONE
            btnSignIn.visibility = View.VISIBLE
            tvForgotPassword.visibility = View.VISIBLE
            tilEmail.visibility = View.VISIBLE
            tilPassword.visibility = View.VISIBLE
        }
    }

    private fun login() = with(binding) {
        val bundle = Bundle()
        btnSignIn.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val model = LoginDto(password, email)
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.getLoginState(model).collect {
                        when (it) {
                            is Resource.Loading -> {
                            }

                            is Resource.Error -> {
                                Log.e("ololo", "setupSubscribes11111: " + it.message)
                            }

                            is Resource.Success -> {
                                val list = it.data?.toUI()
                                userPreferencesData.apply {
                                    isAuthorized = true
                                    accessToken = it.data!!.tokens.access
                                    refreshToken = it.data.tokens.refresh
                                }
                                Log.e("MyApp", "setupSubscribes: $list")
                                dismiss()
                                findNavController().navigate(R.id.action_guestProfileFragment_to_userProfileFragment)
                                bundle.putString("email", etRegEmail.text.toString())
                                val verifyFragment = VerifyAccountFragment()
                                verifyFragment.arguments = bundle
                            }
                        }
                    }
                }
            }
        }
    }

    private fun register() = with(binding) {
        btnRegister.setOnClickListener {
            val email = binding.etRegEmail.text.toString().trim()
            val username = binding.etRegUserName.text.toString().trim()
            val password = binding.etRegPassword.text.toString().trim()
            val usertype = "client"
            val model = RegisterDto(email, username, usertype, password)
            val mess = "IDI NAHUY"
            if (etRegEmail.text.isNullOrEmpty()) {
                tilRegEmail.error = "asd"
            } else if (etRegUserName.text.isNullOrEmpty()) {
                tilRegUserName.error = "asd"
            } else if (etRegPassword.text.isNullOrEmpty()) {
                tilRegPassword.error = "asd"
            } else {
                viewLifecycleOwner.lifecycleScope.launch {
                    viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                        viewModel.getRegisterState(model).collect {
                            when (it) {
                                is Resource.Loading -> {
                                }

                                is Resource.Error -> {
                                    Log.e("ololo", "setupSubscribes11111: " + it.message)
                                }

                                is Resource.Success -> {
                                    userPreferencesData.userEmail = email
                                    findNavController().navigate(R.id.action_guestProfileFragment_to_verifyAccountFragment)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    fun TextInputLayout.setErrorWithTimeout(errorMessage: String) {
        error = errorMessage
        Handler().postDelayed({
            error = null
//        val layoutParams = this.layoutParams
//        val dpVal = 56f
//        layoutParams.height = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, context.resources.displayMetrics).toInt()
//        this.layoutParams = layoutParams
        }, 5000L)
    }
}