package com.example.meyman.presentation.ui.screens.booking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.meyman.databinding.FragmentBookingBinding
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class BookingFragment : Fragment() {

    private val viewModel: BookingViewModel by viewModels()
    private lateinit var binding: FragmentBookingBinding
    private val bookingAdapter = BookingAdapter()

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
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.bookingValue.collect {
                    when (it) {
                        is UIState.Error -> {
//                                binding.progressBar.isVisible = false
                        }

                        is UIState.Loading -> {
//                                binding.progressBar.isVisible = true
                        }

                        is UIState.Success -> {
//                                binding.progressBar.isVisible = false
                            binding.rvBooking.adapter = bookingAdapter
                            bookingAdapter.submitList(it.data)
                        }

                        is UIState.Empty -> {}

                    }
                }
            }
        }
    }

}