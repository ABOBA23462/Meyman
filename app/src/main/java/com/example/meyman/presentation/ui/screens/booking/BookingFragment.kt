package com.example.meyman.presentation.ui.screens.booking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meyman.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookingFragment : Fragment() {

    private lateinit var viewModel: BookingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_booking, container, false)
    }

}