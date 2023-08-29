package com.example.meyman.presentation.ui.screens.room_page

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.meyman.R
import com.example.meyman.core.base.BaseFragment
import com.example.meyman.databinding.FragmentRoomPageBinding
import com.example.meyman.presentation.base.Resource
import com.example.meyman.presentation.models.rooms.ResultsItemUI
import com.example.meyman.presentation.state.UIState
import com.example.meyman.presentation.ui.screens.room_page.tablayout.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RoomPageFragment :
    BaseFragment<FragmentRoomPageBinding, RoomPageViewModel>(R.layout.fragment_room_page) {

    override val binding by viewBinding(FragmentRoomPageBinding::bind)
    override val viewModel: RoomPageViewModel by viewModels()
    private val args: RoomPageFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewPager.adapter = ViewPagerAdapter(this@RoomPageFragment)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
            when (pos) {
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
        setup()
        huy()
    }

    fun huy(){
        viewModel.fetchVerification(args.id)
    }

    private fun setup() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.establishmentState.collect {
                    when (it) {
                        is UIState.Error -> {
                            Log.e("all", it.error)
                            Toast.makeText(requireContext(), it.error, Toast.LENGTH_SHORT).show()
                        }

                        is UIState.Loading -> {
                            Log.e("all", "loading...")
                        }

                        is UIState.Success -> {
                            Log.e("all", "success")
                            it.data.let { data ->
                                binding.tvRoomName.text = data.roomName
                            }
                        }
                    }
                }
            }
        }
    }
}