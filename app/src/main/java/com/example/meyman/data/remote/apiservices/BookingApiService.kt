package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.BookingDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface BookingApiService {

    @GET("history_reservations/")
    suspend fun getBooking(
        @Query("limit") limit: Int? = null,
        @Query("offset") offset: Int? = null
    ): BookingDto

    @GET("history_reservations/{id}/")
    suspend fun getBookingById(
        @Path("id") id: Int
    ): BookingDto
}