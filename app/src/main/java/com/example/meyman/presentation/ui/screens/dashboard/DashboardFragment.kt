package com.example.meyman.presentation.ui.screens.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.meyman.R
import com.example.meyman.databinding.FragmentDashboardBinding
import com.example.meyman.presentation.ui.screens.home.HomeFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class DashboardFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentDashboardBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialize()
    }

    @SuppressLint("ResourceType")
    private fun initialize() = with(binding) {
        var roomNum = 1
        var adultNum = 1
        var childNum = 0

        ivRoomPlus.setOnClickListener {
            tvRoomNum.text = roomNum.toString()
            roomNum++
        }

        ivMinusRoom.setOnClickListener {
            tvRoomNum.text = roomNum.toString()
            roomNum--
        }

        ivAdultPlus.setOnClickListener {
            tvAdultNum.text = adultNum.toString()
            adultNum++
        }

        ivMinusAdult.setOnClickListener {
            tvAdultNum.text = adultNum.toString()
            adultNum--
        }

        ivChildPlus.setOnClickListener {
            tvChildNum.text = childNum.toString()
            childNum++
        }

        ivMinusChild.setOnClickListener {
            tvChildNum.text = childNum.toString()
            childNum--
        }
        btnApply.setOnClickListener {
            val bundle = Bundle()
            bundle.putString("room", tvRoomNum.text.toString())
            bundle.putString("adult", tvAdultNum.toString())
            bundle.putString("child", tvChildNum.toString())
            findNavController().navigate(R.id.homeFragment, bundle)
        }
    }
}