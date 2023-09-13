package com.example.meyman.domain.repositories

import com.example.meyman.domain.utils.Either
import com.example.meyman.domain.utils.models.BookingModel
import com.example.meyman.domain.utils.models.ResultsBookingModel
import kotlinx.coroutines.flow.Flow

interface BookingRepository {

    suspend fun getBooking(): Flow<Either<String, List<ResultsBookingModel>>>

    suspend fun getBookingById(id: Int): Flow<Either<String, BookingModel>>

}