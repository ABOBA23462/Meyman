package com.example.meyman.presentation.ui.screens.acceptAccount

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.meyman.R
import com.example.meyman.databinding.FragmentAcceptAccountBinding
import com.google.android.material.button.MaterialButton

class AcceptAccountFragment : Fragment() {

    private lateinit var binding: FragmentAcceptAccountBinding
    private val viewModel: AcceptAccountViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAcceptAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnAccept.setOnClickListener {
            customAlertDialog()
        }
    }

    private fun customAlertDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_alert_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val btnContinue: MaterialButton = dialog.findViewById(R.id.btn_continue)

        btnContinue.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }


}