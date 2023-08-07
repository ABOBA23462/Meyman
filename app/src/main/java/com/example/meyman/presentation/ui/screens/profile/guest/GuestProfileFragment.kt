package com.example.meyman.presentation.ui.screens.profile.guest

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.meyman.R
import com.example.meyman.core.base.BaseFragment
import com.example.meyman.databinding.FragmentGuestProfileBinding
import com.example.meyman.presentation.ui.screens.sign.`in`.SignInFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GuestProfileFragment : BaseFragment<FragmentGuestProfileBinding, GuestProfileViewModel>(R.layout.fragment_guest_profile) {

    override val binding by viewBinding(FragmentGuestProfileBinding::bind)
    override val viewModel: GuestProfileViewModel by viewModels()

    override fun initialize() {
        super.initialize()
    }

    override fun setupSubscribes() = with(binding) {
        btnSignIn.setOnClickListener {
            val bottomSheetFragment = SignInFragment()
            bottomSheetFragment.show(parentFragmentManager, bottomSheetFragment.tag)
          bottomSheetFragment.dialog?.window?.setBackgroundDrawableResource(R.drawable.rounder)
        }
    }
}