package com.example.meyman.presentation.ui.screens.room_page.booking

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.meyman.R
import com.example.meyman.core.base.BaseFragment
import com.example.meyman.data.remote.preferences.UserDataPreferencesHelper
import com.example.meyman.databinding.FragmentRoomBookingBinding
import com.example.meyman.domain.utils.models.reservation.ReservationPostModel
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class RoomBookingFragment : BaseFragment<FragmentRoomBookingBinding, RoomBookingViewModel>(R.layout.fragment_room_booking) {


    @Inject
    lateinit var userPreferencesData: UserDataPreferencesHelper
    override val binding: FragmentRoomBookingBinding by viewBinding(FragmentRoomBookingBinding::bind)
    override val viewModel: RoomBookingViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_room_booking, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnReserve.setOnClickListener {
            findNavController().navigate(R.id.action_roomBookingFragment_to_reservationFragment)
            viewModel.postReservation("Bearer ${userPreferencesData.accessToken}",ReservationPostModel(2, "2023-09-20", "2024-09-20",
            5, "bazarjol@gmail.com", 1, "+996502775550",
            "erbosha"))
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                    viewModel.reservation.collect {
                        when (it) {
                            is UIState.Error -> {
                                Log.e("erbol", "reservation: " + it.error )
                            }

                            is UIState.Loading -> {
//                                binding.progressBar.isVisible = true
                            }

                            is UIState.Success -> {
                                Log.e("erbol", "reservation: " + it.data )
                            }
                        }
                    }
                }
            }
        }
    }

}