package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.RoomsApiService
import com.example.meyman.data.remote.dtos.toRoomDomain
import com.example.meyman.domain.repositories.ChooseRoomRepository
import javax.inject.Inject

class ChooseRoomRepositoryImpl @Inject constructor(
    private val chooseRoomService: RoomsApiService
) : BaseRepository(), ChooseRoomRepository {

    override suspend fun getChooseRepository() = doRequest {
        chooseRoomService.fetchRooms().results.map { it.toRoomDomain() }
    }
}