package com.example.meyman.data.remote.mappers

import com.example.meyman.data.remote.dtos.TravelItemDto
import com.example.meyman.domain.models.TravelItemModel

fun TravelItemDto.toTravelItemModel() = TravelItemModel(
    id,
    accommodation_type,
    bathrooms,
    bed_type,
    bedrooms,
    beds,
    description,
    food_type,
    housing_amenities.toHousingAmenitiesModel(),
    housing_name,
    housing_type,
    image,
    location,
    price_per_night,
    room_amenities.toRoomAmenitiesModel()
)