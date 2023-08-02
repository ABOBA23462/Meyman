package com.example.meyman.data.remote.dtos

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserDto<T>(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<UsernameDto>
) : Parcelable

@Parcelize
data class UsernameDto(
    val avatar: String,
    val date_joined: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String
) : Parcelable