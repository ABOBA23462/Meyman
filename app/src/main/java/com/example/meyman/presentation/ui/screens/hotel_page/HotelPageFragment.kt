package com.example.meyman.presentation.ui.screens.hotel_page

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.meyman.R
import com.example.meyman.core.base.BaseFragment
import com.example.meyman.databinding.FragmentHotelPageBinding
import com.example.meyman.databinding.FragmentRoomPageBinding
import com.example.meyman.presentation.ui.screens.room_page.RoomPageViewModel
import com.example.meyman.presentation.ui.screens.room_page.tablayout.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class HotelPageFragment : BaseFragment<FragmentHotelPageBinding, HotelPageViewModel>(R.layout.fragment_hotel_page) {

    override val binding by viewBinding(FragmentHotelPageBinding::bind)
    override val viewModel: HotelPageViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewPager.adapter = ViewPagerAdapter(this@HotelPageFragment)
        TabLayoutMediator(binding.tabLayout, binding.viewPager){
                tab, pos ->
            when(pos){
                0 -> {
                    tab.text = "Условия"
                }
                1 -> {
                    tab.text = "Удобства"
                }
                2 -> {
                    tab.text = "Здоровье и гигиена"
                }
                3 -> {
                    tab.text = "Отзывы"
                }
                4 -> {
                    tab.text = "Размещение детей"
                }
            }
        }.attach()
    }

    override fun initialize() {
        super.initialize()

//        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.tl, TabLayoutFragment()).commit()
    }
}