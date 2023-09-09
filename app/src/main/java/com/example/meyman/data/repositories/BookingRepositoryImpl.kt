package com.example.meyman.data.repositories

import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.BookingApiService
import com.example.meyman.data.remote.dtos.toDomain
import com.example.meyman.domain.repositories.BookingRepository
import javax.inject.Inject

class BookingRepositoryImpl @Inject constructor(
    private val bookingApiService: BookingApiService
) : BaseRepository(), BookingRepository {

    override suspend fun getBooking() = doRequest {
        bookingApiService.getBooking().results.map { it.toDomain() }
    }

    override suspend fun getBookingById(id: Int) = doRequest {
        bookingApiService.getBookingById(id).toDomain()
    }


}

