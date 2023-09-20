package com.example.meyman.presentation.ui.screens.hotel_page.rooms

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.meyman.databinding.FragmentRoomsBinding
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RoomsFragment : Fragment() {

    private lateinit var binding: FragmentRoomsBinding
    private val viewModel: RoomsViewModel by viewModels()
    private val adapter = RoomsAdapter(this::onItemClick)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRoomsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupSubscribes()
    }

    private fun initialize() {
        binding.rvChooseRoom.adapter = adapter
    }

    private fun setupSubscribes() {
        subscribeToFetchRooms()

    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(RoomsFragmentDirections.actionRoomsFragmentToRoomPageFragment(id + 1))
    }
    private fun onButtonClick(id: Int) {
        findNavController().navigate(RoomsFragmentDirections.actionRoomsFragmentToRoomBookingFragment(id))
    }

    private fun subscribeToFetchRooms() {
        viewModel.getChooseRoomState()
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.roomsState.collect {
                    when (it) {
                        is UIState.Error -> {
//                                binding.progressBar.isVisible = false
                        }

                        is UIState.Loading -> {
//                                binding.progressBar.isVisible = true
                        }

                        is UIState.Success -> {
//                                binding.progressBar.isVisible = false
                            adapter.submitList(it.data)
                            val itemCount = adapter.itemCount ?: 0
                            binding.textView.text = "$itemCount варианта"
                        }

                        else -> {}
                    }
                }
            }
        }
    }

}