package com.example.meyman.presentation.ui.screens.profile.user

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.meyman.R
import com.example.meyman.core.base.BaseFragment
import com.example.meyman.databinding.FragmentUserProfileBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserProfileFragment : BaseFragment<FragmentUserProfileBinding, UserProfileViewModel>(R.layout.fragment_user_profile) {

    override val binding by viewBinding(FragmentUserProfileBinding::bind)
    override val viewModel: UserProfileViewModel by viewModels()

    override fun initialize() {
        super.initialize()
    }

    override fun setupSubscribes() = with(binding) {
        btnUserChange.setOnClickListener {
            // Переход на экран редактирования профиля пользователя
//            findNavController().navigate(UserProfileFragmentDirections.actionUserProfileFragmentToChangeUserProfileFragment())
        }

        clCall.setOnClickListener {
            // Переход на экран связи
//            findNavController().navigate(UserProfileFragmentDirections.actionUserProfileFragmentToConnectFragment())
        }

        clRentOutHousing.setOnClickListener {
            // Реализовать переход на экран сдачи жилья

        }

        clRentCar.setOnClickListener {
            // Реализовать переход на экран сдачи авто
        }
    }
}