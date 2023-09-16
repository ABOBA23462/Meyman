package com.example.meyman.presentation.ui.screens.chooseRoom

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.meyman.databinding.FragmentChooseRoomBinding
import com.example.meyman.presentation.state.UIState
import com.example.meyman.presentation.ui.screens.chooseRoom.adapter.ChooseRoomAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ChooseRoomFragment : Fragment() {

    private lateinit var binding: FragmentChooseRoomBinding
    private val viewModel: ChooseRoomViewModel by viewModels()
    private val adapter = ChooseRoomAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChooseRoomBinding.inflate(inflater, container, false)
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
        subscribeToFetchHotel()
    }

    private fun subscribeToFetchHotel() {
        viewModel.getChooseRoomState()
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.chooseRoomState.collect {
                    when (it) {
                        is UIState.Error -> {
//                                binding.progressBar.isVisible = false
                        }

                        is UIState.Loading -> {
//                                binding.progressBar.isVisible = true
                        }

                        is UIState.Success -> {
//                                binding.progressBar.isVisible = false
                            adapter.addList(it.data)
                        }
                    }
                }
            }
        }
    }

}