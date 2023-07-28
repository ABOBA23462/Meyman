package com.example.meyman.presentation.ui.screens.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.meyman.presentation.ui.screens.spinerhome.SpinnerItem
import com.example.meyman.presentation.ui.screens.spinerhome.SpinnerItem2
import com.example.meyman.R
import com.example.meyman.databinding.FragmentHomeBinding
import com.example.meyman.presentation.ui.screens.adapter.CustomSpinnerAdapter
import com.example.meyman.presentation.ui.screens.adapter.CustomSpinnerAdapter2
import com.example.meyman.presentation.ui.screens.dashboard.DashboardFragment

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val spinnerItem = listOf(
            SpinnerItem("Russian", R.drawable.rasha2),
            SpinnerItem("English", R.drawable.languages)
        )

        val spinnerItem2 = listOf(
            SpinnerItem2("СОМ", R.drawable.currensy1),
            SpinnerItem2("USD", R.drawable.currensy2),
            SpinnerItem2("EUR", R.drawable.currrensy3)

        )

        val adapter = CustomSpinnerAdapter(requireContext(), R.layout.spinner_item_layout, spinnerItem)
        binding.spinner.adapter = adapter

        val adapter2 = CustomSpinnerAdapter2(requireContext(), R.layout.spinner_item2_layout, spinnerItem2)
        binding.spinner2.adapter = adapter2

        binding.materialCardView3.setOnClickListener {
            val bottomSheetFragment = DashboardFragment()
            bottomSheetFragment.show(parentFragmentManager, bottomSheetFragment.tag)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}