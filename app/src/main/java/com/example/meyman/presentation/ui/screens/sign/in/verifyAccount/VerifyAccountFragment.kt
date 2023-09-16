package com.example.meyman.presentation.ui.screens.sign.`in`.verifyAccount

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.meyman.R
import com.example.meyman.data.remote.dtos.auth.VerifyDto
import com.example.meyman.databinding.FragmentVerifyAccountBinding
import com.example.meyman.presentation.base.Resource
import com.example.meyman.presentation.models.auth.toUI
import com.google.android.material.button.MaterialButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class VerifyAccountFragment : Fragment() {

    private lateinit var binding: FragmentVerifyAccountBinding
    private val viewModel: VerifyAccountViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentVerifyAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnAccept.setOnClickListener {
            customAlertDialog()
            val code = binding.etCode.text.toString()
            val email = arguments?.getString("email")
            val model = VerifyDto(code, email.toString())
            Log.d("qwerty", "$model")
            Log.d("MyApp", "Email: $email, code: $code")
            if (code.length == 4) {
                viewLifecycleOwner.lifecycleScope.launch {
                    viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                        viewModel.getVerifyState(model).collect {
                            when (it) {
                                is Resource.Loading -> {
                                }
                                is Resource.Error -> {
                                    Log.e("ololo", "setupSubscribes11111: " + it.message)
                                    Toast.makeText(
                                        requireContext(),
                                        "Не правильный код",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                                is Resource.Success -> {
                                    val list = it.data?.toUI()
                                    Log.e("MyApp", "setupSubscribes: $list")
                                }
                            }
                        }
                    }
                }
            }
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