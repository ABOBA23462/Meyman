package com.example.meyman.presentation.ui.screens.room_page

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.meyman.R
import com.example.meyman.core.base.BaseFragment
import com.example.meyman.databinding.FragmentRoomPageBinding
import com.example.meyman.presentation.ui.screens.room_page.tablayout.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RoomPageFragment : BaseFragment<FragmentRoomPageBinding, RoomPageViewModel>(R.layout.fragment_room_page) {

    override val binding by viewBinding(FragmentRoomPageBinding::bind)
    override val viewModel: RoomPageViewModel by viewModels()
    private val args: RoomPageFragmentArgs by navArgs()

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
    }

    override fun setupSubscribes() = with(binding) {
        viewModel.fetchDetail(args.id).subscribes(
            onFailure = {},
            onSuccess = { data ->
                tvRoomName.text = data.roomName
            }
        )
    }
}