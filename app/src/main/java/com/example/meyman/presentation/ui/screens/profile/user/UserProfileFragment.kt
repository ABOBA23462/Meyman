package com.example.meyman.presentation.ui.screens.profile.user

import android.util.Log
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.meyman.R
import com.example.meyman.core.base.BaseFragment
import com.example.meyman.data.remote.preferences.UserDataPreferencesHelper
import com.example.meyman.databinding.FragmentUserProfileBinding
import com.example.meyman.presentation.state.UIState
import com.example.meyman.presentation.ui.screens.room_page.PhotoPageAdapter
import com.example.meyman.presentation.ui.screens.room_page.RoomAmenitiesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class UserProfileFragment : BaseFragment<FragmentUserProfileBinding, UserProfileViewModel>(R.layout.fragment_user_profile) {

    @Inject
    lateinit var userPreferencesData: UserDataPreferencesHelper
    override val binding by viewBinding(FragmentUserProfileBinding::bind)
    override val viewModel: UserProfileViewModel by viewModels()

    override fun initialize() {
setupSubscribes()
        profile()
    }

    private fun profile() {
        viewModel.fetchUserProfile("Bearer ${userPreferencesData.accessToken}")
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.userProfileState.collect {
                    Log.e("ololo", "RPF: ${it}")
                    when (it) {
                        is UIState.Error -> {
                            Log.e("ololo", "RPAE: ${it.error}")
                        }
                        is UIState.Loading -> {}
                        is UIState.Success -> {
                            binding.tvProfileName.text = it.data.username
                            binding.ivProfileIcon.setImage(it.data.image)
                            Log.e("ololo", "RPAS: ${it.data}")
                        }
                    }
                }
            }
        }
    }

    fun ImageView.setImage(uri: String) {
        Glide.with(this)
            .load(uri)
            .into(this)
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