package com.example.meyman.presentation.ui.screens.profile.guest

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meyman.R

class GuestProfileFragment : Fragment() {

    companion object {
        fun newInstance() = GuestProfileFragment()
    }

    private lateinit var viewModel: GuestProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_guest_profile, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(GuestProfileViewModel::class.java)
        // TODO: Use the ViewModel
    }

}