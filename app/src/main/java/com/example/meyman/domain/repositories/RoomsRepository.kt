package com.example.meyman.domain.repositories

import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.rooms.ResultsRoomsItemModel
import com.example.meyman.domain.utils.models.rooms.list.ResultsRoomsListItemModel
import kotlinx.coroutines.flow.Flow

interface RoomsRepository {

    fun fetchRooms(): Flow<Either<String, List<ResultsRoomsListItemModel>?>>

    fun fetchDetailRooms(id: Int): Flow<Either<String, ResultsRoomsItemModel?>>
}