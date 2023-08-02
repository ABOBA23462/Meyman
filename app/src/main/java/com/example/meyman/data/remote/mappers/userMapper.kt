package com.example.meyman.data.remote.mappers

import com.example.meyman.data.remote.dtos.UserDto
import com.example.meyman.data.remote.dtos.UsernameDto
import com.example.meyman.domain.models.UserModel
import com.example.meyman.domain.models.UsernameModel

fun UserDto.toUserModel() = UserModel(
    count,
    next,
    previous,
    results = results.map { it.toUsernameModel() }
)

fun UsernameDto.toUsernameModel() = UsernameModel(
    id,
    avatar,
    date_joined,
    email,
    first_name,
    last_name
)