package com.example.meyman.data.remote.apiservices

import com.example.meyman.data.remote.dtos.HotelDto
import com.example.meyman.data.remote.dtos.TravelItemDto
import com.example.meyman.data.remote.dtos2.HotelsDto
import com.example.meyman.data.remote.dtos2.ResultDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface HotelApiService {

    @GET("travel/hotels/")

    suspend fun getHotelResult(
        @Query("housing_type") housing_type: String = "",

        @Query("accommodation_type") accommodation_type: String = "",

        @Query("food_type") food_type: String = "",

        //звездочки
        @Query("stars") stars: String = "",

        //заезд
        @Query("housing_amenities") housing_amenities: String = "",

        //выезд
        @Query("page") page: String = "",

        //рейтинг
        @Query("rating_range") rating_range: String = "",

        //удобства
        @Query("page_size") page_size: String = "",
    ): HotelsDto<ResultDto>

    @GET("travel/hotels/{id}")
    suspend fun fetchHotel(@Path("id") id: Int): ResultDto
}