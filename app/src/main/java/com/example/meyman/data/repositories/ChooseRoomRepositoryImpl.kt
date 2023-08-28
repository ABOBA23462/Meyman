package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.ChooseRoomService
import com.example.meyman.data.remote.dtos.toRoomDomain
import com.example.meyman.domain.repositories.ChooseRoomRepository
import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.ChooseRoomModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

class ChooseRoomRepositoryImpl @Inject constructor(
    private val chooseRoomService: ChooseRoomService
) : BaseRepository(), ChooseRoomRepository {

    override suspend fun getChooseRepository() = doRequest {
        chooseRoomService.getChooseRoom().results.map { it.toRoomDomain() }
    }

}