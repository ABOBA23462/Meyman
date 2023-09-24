package com.example.meyman.presentation.ui.screens.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController

import com.example.meyman.R
import com.example.meyman.databinding.FragmentHomeBinding
import com.example.meyman.presentation.state.UIState
import com.example.meyman.presentation.ui.adapter.CustomSpinnerAdapter
import com.example.meyman.presentation.ui.adapter.CustomSpinnerAdapter2
import com.example.meyman.presentation.ui.screens.dashboard.DashboardFragment
import com.example.meyman.presentation.ui.screens.home.adapter.AdvertisingAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private val adapter = AdvertisingAdapter()

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
     binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupSubscribes()

//        val receivedBundle = arguments
//        val roomNum = receivedBundle?.getString("room", "1")
//        val adultNum = receivedBundle?.getString("adult", "1")
//        val childNum = receivedBundle?.getString("child", "1")
//
//        binding.tvOptions1.text = "$roomNum номер"
//        binding.tvOptions2.text = "$adultNum взрослых"
//        binding.tvOptions1.text = "$childNum детей"
//        Toast.makeText(requireContext(), "$roomNum + $adultNum + $childNum", Toast.LENGTH_SHORT).show()

        binding.mcvOptions.setOnClickListener {
            val bottomSheetFragment = DashboardFragment()
            bottomSheetFragment.show(parentFragmentManager, bottomSheetFragment.tag)
        }

        binding.btnSearch.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_searchResultsFragment)
        }
    }

    private fun initialize() {
        binding.rvRecomend.adapter = adapter
    }

    private fun setupSubscribes() {
        subscribeToFetchAdvertising()
    }

    private fun subscribeToFetchAdvertising() {
            viewModel.getAdvertising()
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                    viewModel.advertisingState.collect {
                        when (it) {
                            is UIState.Error -> {
                                Toast.makeText(requireContext(), "ABOBA", Toast.LENGTH_SHORT).show()
                                Log.e("homka", "subscribeToFetchAdvertising: ${it.error}" )
//                                binding.progressBar.isVisible = false
                            }

                            is UIState.Loading -> {
                                Toast.makeText(requireContext(), "ABOBA", Toast.LENGTH_SHORT).show()
//                                binding.progressBar.isVisible = true
                            }

                            is UIState.Success -> {
                                Toast.makeText(requireContext(), "ABOBA", Toast.LENGTH_SHORT).show()
                                Log.e("homka", "subscribeToFetchAdvertising: ${it.data}" )
                                adapter.submitList(it.data)
                            }

                            else -> {}
                        }
                    }
                }
            }
        }
    }