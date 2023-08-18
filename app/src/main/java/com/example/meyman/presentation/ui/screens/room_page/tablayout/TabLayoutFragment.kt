package com.example.meyman.presentation.ui.screens.room_page.tablayout

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.meyman.R
import com.example.meyman.core.base.BaseFragment
import com.example.meyman.databinding.FragmentConditionsBinding
import com.example.meyman.databinding.FragmentTabLayoutBinding
import com.example.meyman.presentation.ui.screens.room_page.tablayout.conditions.ConditionsViewModel
import com.google.android.material.tabs.TabLayoutMediator

class TabLayoutFragment : Fragment(R.layout.fragment_tab_layout) {

    private val binding by viewBinding(FragmentTabLayoutBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       initialize()
    }

    private fun initialize() {

    }


}