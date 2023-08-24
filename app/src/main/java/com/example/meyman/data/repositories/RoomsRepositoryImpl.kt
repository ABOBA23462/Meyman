package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.RoomsApiService
import com.example.meyman.data.remote.dtos.rooms.toDomain
import com.example.meyman.domain.repositories.RoomsRepository
import com.example.meyman.domain.utils.models.rooms.ResultsItemModel
import com.example.meyman.presentation.base.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RoomsRepositoryImpl @Inject constructor(
    private val service: RoomsApiService
) : BaseRepository(), RoomsRepository {

    override suspend fun fetchRooms() = doRequest {
        service.fetchRooms().results.map{
            it.toDomain()
        }
    }

    override fun fetchDetailRooms(id: Int): Flow<Resource<ResultsItemModel>> = doRequests {
        service.fetchDetailRoom(id).toDomain()
    }
}