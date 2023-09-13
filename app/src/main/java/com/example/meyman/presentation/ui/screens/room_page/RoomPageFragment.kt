package com.example.meyman.presentation.ui.screens.room_page

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.meyman.R
import com.example.meyman.core.base.BaseFragment
import com.example.meyman.databinding.FragmentRoomPageBinding
import com.example.meyman.presentation.models.rooms.ResultsRoomsItemUI
import com.example.meyman.presentation.state.UIState
import com.example.meyman.presentation.ui.screens.hotel_page.rooms.PhotoAdapter
import com.example.meyman.presentation.ui.screens.room_page.tablayout.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RoomPageFragment :
    BaseFragment<FragmentRoomPageBinding, RoomPageViewModel>(R.layout.fragment_room_page) {

    override val binding by viewBinding(FragmentRoomPageBinding::bind)
    override val viewModel: RoomPageViewModel by viewModels()
    private val args: RoomPageFragmentArgs by navArgs()
    private lateinit var adapter: PhotoPageAdapter
    private lateinit var adapterAmenities: RoomAmenitiesAdapter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.e("ololo", "getChooseRoomState: ${args.id}")
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
        viewModel.fetchRoom(args.id)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.roomState.collect {
                    Log.e("ololo", "RPF: ${it}")
                    when (it) {
                        is UIState.Error -> {
                            Log.e("ololo", "RPAE: ${it.error}")
                        }
                        is UIState.Loading -> {}
                        is UIState.Success -> {
                            Log.e("ololo", "RPAS: ${it.data}")
                            binding.tvTitle.text = it.data.pricePerNight
                            binding.tvRoomSquare.text = "${it.data.roomArea} m²"
                            binding.tvHotelAmenities.text = "Двухместная кровать ${it.data.bedType} и диван "
                            adapter = PhotoPageAdapter()
                            binding.rvPhoto.adapter = adapter
                            val snapHelper: SnapHelper = PagerSnapHelper()
                            snapHelper.attachToRecyclerView(binding.rvPhoto)
                            it.data.roomImages?.let { adapter.submitList(it) }
                            adapterAmenities = RoomAmenitiesAdapter(it.data.roomAmenities!!)
                            binding.rvRoomAmenities.adapter = adapterAmenities
                        }

                        is UIState.Empty -> {}
                    }
                }
            }
        }
        binding.ivShare.setOnClickListener {
            val pageLink = "https://www.example.com/meyman/presentation/ui/screens/room_page"
            val sharingIntent = Intent(Intent.ACTION_SEND)
            sharingIntent.type = "text/plain"
            sharingIntent.putExtra(Intent.EXTRA_TEXT, pageLink)
            startActivity(Intent.createChooser(sharingIntent, "Поделиться через"))
        }


    }

    override fun setupSubscribes() {

    }
}