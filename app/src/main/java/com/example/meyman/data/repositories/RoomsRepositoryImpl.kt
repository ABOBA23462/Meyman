package com.example.meyman.data.repositories

import android.util.Log
import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.RoomsApiService
import com.example.meyman.data.remote.dtos.rooms.toDomain
import com.example.meyman.domain.repositories.RoomsRepository
import javax.inject.Inject

class RoomsRepositoryImpl @Inject constructor(
    private val service: RoomsApiService
) : BaseRepository(), RoomsRepository {

    override suspend  fun fetchDetailRooms(id: Int) = doRequest {
        service.fetchDetailRoom(id).body()?.toDomain()
    }
}