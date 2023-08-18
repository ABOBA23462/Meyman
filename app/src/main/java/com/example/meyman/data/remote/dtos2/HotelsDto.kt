package com.example.meyman.data.remote.dtos2

data class HotelsDto<T>(
    val count: Int,
    val next: Any,
    val previous: Any,
    val results: List<T>
)