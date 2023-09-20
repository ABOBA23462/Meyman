package com.example.meyman.presentation.ui.screens.search_results

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.meyman.R
import com.example.meyman.databinding.FragmentSearchResultsBinding
import com.example.meyman.presentation.models.hotels.ResultsHotelItemUI
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SearchResultsFragment : Fragment() {

    private lateinit var binding: FragmentSearchResultsBinding
    private val viewModel: SearchResultViewModel by viewModels()
    private val reviewAdapter = SearchResultsAdapter(this::onClick)


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
        subscribeToFetchHotel()

    }

    private fun onClick(hotelsResult: ResultsHotelItemUI) {
        findNavController().navigate(R.id.hotelPageFragment, bundleOf("id" to hotelsResult.id))
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
                            binding.rvSearchResults.adapter = reviewAdapter
                            reviewAdapter.submitList(it.data)
                        }
                    }
                }
            }
        }
    }

}