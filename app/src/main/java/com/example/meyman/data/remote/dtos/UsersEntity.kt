package com.example.meyman.data.remote.dtos

data class UsersEntity(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<User>
) {
    data class User(
        val avatar: String,
        val date_joined: String,
        val email: String,
        val first_name: String,
        val id: Int,
        val last_name: String
    )
}