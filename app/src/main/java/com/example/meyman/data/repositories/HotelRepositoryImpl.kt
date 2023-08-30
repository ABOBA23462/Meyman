package com.example.meyman.data.repositories

import android.util.Log
import com.example.meyman.core.base.BaseRepository
import com.example.meyman.data.remote.apiservices.HotelApiService
import com.example.meyman.data.remote.dtos.toDomain
import com.example.meyman.domain.repositories.HotelRepository
import javax.inject.Inject
import kotlin.math.log

class HotelRepositoryImpl @Inject constructor(
    private val hotelApiService: HotelApiService
) : BaseRepository(), HotelRepository {

    override suspend fun fetchHotel() = doRequest {
        hotelApiService.getHotelResult().results?.map { it.toDomain() }
    }

    override suspend fun getHotelById(id: Int) = doRequest {
        hotelApiService.getHotelById(id).toDomain()
    }

}

// override suspend fun getHotelById(id: Int): Flow<Either<String, HotelByIdModel>> = flow {
//        emit(Either.Right(hotelApiService.getHotelById(id).toHotelByIdDomain()))
//        Log.e("ololo", "getHotelById: ${hotelApiService.getHotelById(id)}", )
//    }