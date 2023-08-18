package com.example.meyman.presentation.ui.screens.hotel_page.photos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meyman.R

class HotelPhotosFragment : Fragment() {

    companion object {
        fun newInstance() = HotelPhotosFragment()
    }

    private lateinit var viewModel: HotelPhotosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_hotel_photos, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HotelPhotosViewModel::class.java)
        // TODO: Use the ViewModel
    }

}