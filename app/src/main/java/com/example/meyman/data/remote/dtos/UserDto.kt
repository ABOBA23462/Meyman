package com.example.meyman.data.remote.dtos

data class UserDto(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<UserItemDto>
)

data class UserItemDto(
    val avatar: String,
    val date_joined: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String
)