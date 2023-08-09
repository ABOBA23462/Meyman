package com.example.meyman.presentation.ui.screens.room_page.booking

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meyman.R

class RoomBookingFragment : Fragment() {

    companion object {
        fun newInstance() = RoomBookingFragment()
    }

    private lateinit var viewModel: RoomBookingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_room_booking, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RoomBookingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}