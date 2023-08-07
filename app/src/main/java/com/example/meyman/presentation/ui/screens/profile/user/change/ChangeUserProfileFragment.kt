package com.example.meyman.presentation.ui.screens.profile.user.change

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.meyman.R
import com.example.meyman.core.base.BaseFragment
import com.example.meyman.databinding.FragmentChangeUserProfileBinding

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChangeUserProfileFragment : BaseFragment<FragmentChangeUserProfileBinding, ChangeUserProfileViewModel>(R.layout.fragment_change_user_profile) {

    override val binding by viewBinding(FragmentChangeUserProfileBinding::bind)
    override val viewModel: ChangeUserProfileViewModel by viewModels()

    override fun initialize() {
        super.initialize()
    }

    override fun setupSubscribes() = with(binding) {
        ivBack.setOnClickListener {
            findNavController().navigateUp()
        }
        tvSave.setOnClickListener {
            // Сохранение изменений и переход на экран профиля пользователя
//            findNavController().navigate(ChangeUserProfileFragmentDirections.actionChangeUserProfileFragmentToUserProfileFragment2())
        }
    }
}