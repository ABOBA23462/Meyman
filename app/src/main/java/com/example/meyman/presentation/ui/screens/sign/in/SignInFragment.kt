package com.example.meyman.presentation.ui.screens.sign.`in`

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import com.example.meyman.R
import com.example.meyman.databinding.FragmentSignInBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

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

        tvSignUp.setOnClickListener {
            tvSignUp.setTextColor(ContextCompat.getColor(requireContext() ,R.color.blue1))
            tvSignIn.setTextColor(ContextCompat.getColor(requireContext() ,R.color.black))
            tilEmail.visibility = View.GONE
            tilPassword.visibility = View.GONE
            tilRegEmail.visibility = View.VISIBLE
            tilRegUserName.visibility = View.VISIBLE
            tilRegUserSurname.visibility = View.VISIBLE
            tilConfirmPassword.visibility = View.VISIBLE
            tilRegPassword.visibility = View.VISIBLE
        }
        tvSignIn.setOnClickListener {
            tvSignUp.setTextColor(ContextCompat.getColor(requireContext() ,R.color.black))
            tvSignIn.setTextColor(ContextCompat.getColor(requireContext() ,R.color.blue1))
            tilEmail.visibility = View.VISIBLE
            tilPassword.visibility = View.VISIBLE
            tilRegEmail.visibility = View.GONE
            tilRegUserName.visibility = View.GONE
            tilRegUserSurname.visibility = View.GONE
            tilConfirmPassword.visibility = View.GONE
            tilRegPassword.visibility = View.GONE
        }
    }
}