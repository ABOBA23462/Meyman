package com.example.meyman.presentation.ui.screens.room_page

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
import com.example.meyman.databinding.FragmentRoomPageBinding
import com.example.meyman.presentation.ui.screens.room_page.tablayout.TabLayoutFragment
import com.example.meyman.presentation.ui.screens.room_page.tablayout.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class RoomPageFragment : BaseFragment<FragmentRoomPageBinding, RoomPageViewModel>(R.layout.fragment_room_page) {

    override val binding by viewBinding(FragmentRoomPageBinding::bind)
    override val viewModel: RoomPageViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewPager.adapter = ViewPagerAdapter(this@RoomPageFragment)
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
                    tab.text = "Отзывы"
                }
                3 -> {
                    tab.text = "Дети и дополнительные кровати"
                }
            }
        }.attach()
    }

    override fun initialize() {
        super.initialize()

//        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.tl, TabLayoutFragment()).commit()
    }
}