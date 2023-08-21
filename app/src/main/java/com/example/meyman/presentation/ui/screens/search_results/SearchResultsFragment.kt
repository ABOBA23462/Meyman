package com.example.meyman.presentation.ui.screens.search_results

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.meyman.databinding.FragmentSearchResultsBinding
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchResultsFragment : Fragment() {

    private lateinit var binding: FragmentSearchResultsBinding
    private val viewModel: SearchResultViewModel by viewModels()
    private val reviewAdapter = SearchResultsAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchResultsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupSubscribes()
    }

    private fun initialize() {
        binding.rvSearchResults.adapter = reviewAdapter
    }

    private fun setupSubscribes() {
        subscribeToFetchHotel()
    }

    private fun subscribeToFetchHotel() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.hotelState.collect {
                    when (it) {
                        is UIState.Error -> {
//                                binding.progressBar.isVisible = false
                        }
                        is UIState.Loading -> {
//                                binding.progressBar.isVisible = true
                        }
                        is UIState.Success -> {
//                                binding.progressBar.isVisible = false
                            reviewAdapter.submitList(it.data)
                        }
                    }
                }
            }
        }
    }
}