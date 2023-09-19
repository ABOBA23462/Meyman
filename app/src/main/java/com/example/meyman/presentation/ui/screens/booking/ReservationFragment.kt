package com.example.meyman.presentation.ui.screens.booking

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
import com.example.meyman.data.remote.preferences.UserDataPreferencesHelper
import com.example.meyman.databinding.FragmentBookingBinding
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import kotlinx.coroutines.processNextEventInCurrentThread
import javax.inject.Inject

@AndroidEntryPoint
class ReservationFragment : Fragment() {

    @Inject
    lateinit var userPreferencesData: UserDataPreferencesHelper
    private val viewModel: ReservationViewModel by viewModels()
    private lateinit var binding: FragmentBookingBinding
    private val reservationAdapter = ReservationAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupSubscribes()
    }

    private fun setupSubscribes() {
        Log.e("erbol", "access: " + userPreferencesData.accessToken )
        viewModel.getReservation("Bearer ${userPreferencesData.accessToken}")
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
                            binding.rvBooking.adapter = reservationAdapter
                            reservationAdapter.submitList(it.data)
                        }
                    }
                }
            }
        }
    }

}