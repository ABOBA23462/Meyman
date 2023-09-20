package com.example.meyman.domain.usecases

import com.example.meyman.domain.repositories.ReservationRepo
import com.example.meyman.domain.utils.models.reservation.ReservationPostModel
import javax.inject.Inject

class PostReservationUseCase @Inject constructor(
    private val repo: ReservationRepo
){
    suspend fun postReservation(
        token: String,
        reservationPostModel: ReservationPostModel
    ) = repo.postReservation(token, reservationPostModel)

}