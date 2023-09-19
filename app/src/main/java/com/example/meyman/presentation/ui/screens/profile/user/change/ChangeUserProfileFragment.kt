package com.example.meyman.presentation.ui.screens.profile.user.change

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.meyman.R
import com.example.meyman.core.base.BaseFragment
import com.example.meyman.data.remote.preferences.UserDataPreferencesHelper
import com.example.meyman.databinding.FragmentChangeUserProfileBinding
import com.example.meyman.presentation.state.UIState

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.ByteArrayInputStream
import java.io.File
import java.io.InputStream
import javax.inject.Inject

@AndroidEntryPoint
class ChangeUserProfileFragment : BaseFragment<FragmentChangeUserProfileBinding, ChangeUserProfileViewModel>(R.layout.fragment_change_user_profile) {

    @Inject
    lateinit var userPreferencesData: UserDataPreferencesHelper
    private var uri: Uri = Uri.EMPTY
    override val binding by viewBinding(FragmentChangeUserProfileBinding::bind)
    override val viewModel: ChangeUserProfileViewModel by viewModels()

    private var localAva = false
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK && it.data != null) {
                uri = it.data?.data!!
                localAva = true
                binding.ivUserAvatar.loadImage(uri.toString())
            }
        }

    fun ImageView.loadImage(url: String) {
        Glide.with(this).load(url).into(this)
    }

    override fun initialize() {
        super.initialize()
    }

    private fun saveImage() {
        val pickImageIntent = Intent()
        pickImageIntent.type = "image/*"
        pickImageIntent.action = Intent.ACTION_PICK
        launcher.launch(pickImageIntent)
    }

    override fun setupSubscribes() = with(binding) {

        ivBack.setOnClickListener {
            findNavController().navigateUp()
        }
        ivUserAvatar.setOnClickListener {
            saveImage()
        }
        tvSave.setOnClickListener {
            val fullName = etUserName.text.toString()
            val phoneNumber = etUserPhoneNumber.text.toString()
            Log.e("ABOBA", "setupSubscribes: + ${fullName + phoneNumber} ")
            val  fullnamePart = RequestBody.create("fullname".toMediaTypeOrNull(), fullName)
            val phoneNumberPart =
                RequestBody.create("phone_number".toMediaTypeOrNull(), phoneNumber)

            var inputStream: InputStream = ByteArrayInputStream(byteArrayOf())
            if (uri != Uri.EMPTY) {
                inputStream = context?.contentResolver?.openInputStream(uri)!!
            }

            val file = File(context?.cacheDir, "temp_image.jpeg")


            inputStream.let { input ->
                file.outputStream().use { output ->
                    input.copyTo(output)
                }
            }

            val imageRequestBody = file.asRequestBody("image/*".toMediaTypeOrNull())
            val avatar = imageRequestBody.let {
                MultipartBody.Part.createFormData(
                    "image", file.name,
                    it
                )
            }
            Log.e("ABOBA", "setupSubscribes:   ${avatar} + ${fullnamePart} + ${phoneNumberPart}")
            Log.e("ABOBA", "setupSubscribes:   ${avatar} + ${fullName} + ${phoneNumber}")
            viewModel.fetchUserProfile("Bearer ${userPreferencesData.accessToken}", avatar, fullnamePart, phoneNumberPart)
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.changeUserProfileState.collect {
                        Log.e("ololo", "RPF: ${it}")
                        when (it) {
                            is UIState.Error -> {
                                Log.e("ololo", "RPAE: ${it.error}")
                            }
                            is UIState.Loading -> {}
                            is UIState.Success -> {
                                Log.e("ololo", "RPAS: ${it.data}")
                            }
                        }
                    }
                }
            }
        }
    }
}