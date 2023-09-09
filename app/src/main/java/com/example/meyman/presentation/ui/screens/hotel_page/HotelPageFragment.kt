package com.example.meyman.presentation.ui.screens.hotel_page

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.example.meyman.R
import com.example.meyman.core.base.BaseFragment
import com.example.meyman.databinding.FragmentHotelPageBinding
import com.example.meyman.presentation.state.UIState
import com.example.meyman.presentation.ui.screens.hotel_page.tabLayout.HotelPageViewPagerAdapter
import com.example.meyman.presentation.ui.screens.room_page.tablayout.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HotelPageFragment :
    BaseFragment<FragmentHotelPageBinding, HotelPageViewModel>(R.layout.fragment_hotel_page) {

    override val binding by viewBinding(FragmentHotelPageBinding::bind)
    override val viewModel: HotelPageViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewPager.adapter = HotelPageViewPagerAdapter(this@HotelPageFragment)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
            when (pos) {
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

        callHotelApi()
    }

    private fun callHotelApi() {
        viewModel.getHotelById(id = 1)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.hotelValue.collect {
                    Log.e("ololo", "HotelPageFragment: ${it}", )
                    when(it){
                        is UIState.Empty ->{}
                        is UIState.Error ->{
                            Log.e("ololo", "callHotelApi-error: ${it.error}", )
                        }
                        is UIState.Loading ->{}
                        is UIState.Success ->{
                            Log.e("ololo", "callHotelApi-success: ${it.data}", )
                            with(binding){
                                tvTitle.text = it.data.address
                                tvRatingScore.text = it.data.stars.toString()
                                tvHotelName.text = it.data.housing_name
                            }
                        }
                    }
                }
            }
        }
    }

}