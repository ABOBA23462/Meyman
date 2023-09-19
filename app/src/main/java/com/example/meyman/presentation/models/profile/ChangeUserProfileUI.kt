package com.example.meyman.presentation.models.profile

import com.example.meyman.domain.utils.models.profile.ChangeUserProfileModel
import com.google.gson.annotations.SerializedName

data class ChangeUserProfileUI(
    @SerializedName("image")
    val image: String ?= "http://a850-212-112-111-34.ngrok-free.app/media/media/avatars/photo_2023-09-17_03.19.35_anMPxm4.jpeg",
    @SerializedName("user_type")
    val userType: String = "",
    @SerializedName("phone_number")
    val phoneNumber: String ?= "+996778358018",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("email")
    val email: String = "",
    @SerializedName("username")
    val username: String = ""
)

fun ChangeUserProfileModel.toUI() = ChangeUserProfileUI(
    image,
    userType,
    phoneNumber,
    id,
    email,
    username
)