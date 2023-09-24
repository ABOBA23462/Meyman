package com.example.meyman.domain.repositories

import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.hotels.ResultsHotelItemModel
import com.example.meyman.domain.utils.models.rooms.ResultsRoomsItemModel
import com.example.meyman.domain.utils.models.rooms.list.ResultsRoomsListItemModel
import com.example.meyman.presentation.models.hotels.ResultsHotelItemUI
import kotlinx.coroutines.flow.Flow

interface RoomsRepository {

    fun fetchRooms(id: Int): Flow<Either<String, ResultsHotelItemModel>>

    fun fetchDetailRooms(id: Int): Flow<Either<String, ResultsRoomsItemModel?>>
}