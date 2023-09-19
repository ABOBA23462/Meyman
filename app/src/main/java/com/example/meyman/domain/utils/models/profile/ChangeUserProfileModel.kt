package com.example.meyman.domain.utils.models.profile

import com.google.gson.annotations.SerializedName

data class ChangeUserProfileModel(
    val image: String ?= "http://a850-212-112-111-34.ngrok-free.app/media/media/avatars/photo_2023-09-17_03.19.35_anMPxm4.jpeg",
    val userType: String = "",
    val phoneNumber: String ?= "+996778358018",
    val id: Int = 0,
    val email: String = "",
    val username: String = ""
)