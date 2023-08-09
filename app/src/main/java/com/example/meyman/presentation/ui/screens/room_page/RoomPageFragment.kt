package com.example.meyman.presentation.ui.screens.room_page

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meyman.R

class RoomPageFragment : Fragment() {

    companion object {
        fun newInstance() = RoomPageFragment()
    }

    private lateinit var viewModel: RoomPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_room_page, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RoomPageViewModel::class.java)
        // TODO: Use the ViewModel
    }

}