package com.example.meyman.presentation.models

import android.os.Parcelable
import com.example.meyman.domain.utils.models.HousingAmenitiesModel

data class HousingAmenitiesUI(
    val air_conditioner: Boolean,
    val airport_transfer: Boolean,
    val atm_on_site: Boolean,
    val bar: Boolean,
    val bar_or_restaurant: Boolean,
    val bell_staff_porter: Boolean,
    val breakfast_in_room: Boolean,
    val buffet_breakfast: Boolean,
    val car_rental: Boolean,
    val coffee_teapot: Boolean,
    val concierge_service: Boolean,
    val conference_banquet_hall: Boolean,
    val currency_exchange: Boolean,
    val daily_cleaning: Boolean,
    val dry_cleaning: Boolean,
    val express_check_in: Boolean,
    val facial_treatments: Boolean,
    val fax_xerox: Boolean,
    val fire_extinguishers: Boolean,
    val fitness: Boolean,
    val food_delivery_to_room_paid: Boolean,
    val foot_massage: Boolean,
    val free_instant_coffee: Boolean,
    val free_internet: Boolean,
    val free_tea: Boolean,
    val free_wifi: Boolean,
    val full_body_massage: Boolean,
    val full_time_front_desk: Boolean,
    val full_time_security: Boolean,
    val garden: Boolean,
    val garden_furniture: Boolean,
    val hammam: Boolean,
    val happy_hour: Boolean,
    val head_massage: Boolean,
    val heating: Boolean,
    val housing: Int,
    val id: Int,
    val individual_check_in_check_out: Boolean,
    val indoor_pool: Boolean,
    val indoor_pool_heated: Boolean,
    val internet_business_center: Boolean,
    val invoices_issued: Boolean,
    val ironing_facilities: Boolean,
    val kids_menu: Boolean,
    val laundry_service: Boolean,
    val lockers: Boolean,
    val luggage_storage: Boolean,
    val manual_massage: Boolean,
    val massage: Boolean,
    val neck_massage: Boolean,
    val non_smoking_rooms: Boolean,
    val outdoor_surveillance: Boolean,
    val packed_lunches: Boolean,
    val paid_cleaning: Boolean,
    val paid_laundry: Boolean,
    val parking: Boolean,
    val pet_allowed: Boolean,
    val pool: Boolean,
    val public_areas_surveillance: Boolean,
    val restaurant: Boolean,
    val room_service: Boolean,
    val safe: Boolean,
    val security_alarm: Boolean,
    val shoe_shine: Boolean,
    val smoke_detectors: Boolean,
    val smoking_areas: Boolean,
    val spa_services: Boolean,
    val special_diet_menu: Boolean,
    val steam_room: Boolean,
    val sun_terrace: Boolean,
    val taxi_service: Boolean,
    val transfer_paid: Boolean,
    val wifi: Boolean,
    val wine_champagne: Boolean
)

fun HousingAmenitiesModel.toUI() = HousingAmenitiesUI(
    air_conditioner,
    airport_transfer,
    atm_on_site,
    bar,
    bar_or_restaurant,
    bell_staff_porter,
    breakfast_in_room,
    buffet_breakfast,
    car_rental,
    coffee_teapot,
    concierge_service,
    conference_banquet_hall,
    currency_exchange,
    daily_cleaning,
    dry_cleaning,
    express_check_in,
    facial_treatments,
    fax_xerox,
    fire_extinguishers,
    fitness,
    food_delivery_to_room_paid,
    foot_massage,
    free_instant_coffee,
    free_internet,
    free_tea,
    free_wifi,
    full_body_massage,
    full_time_front_desk,
    full_time_security,
    garden,
    garden_furniture,
    hammam,
    happy_hour,
    head_massage,
    heating,
    housing,
    id,
    individual_check_in_check_out,
    indoor_pool,
    indoor_pool_heated,
    internet_business_center,
    invoices_issued,
    ironing_facilities,
    kids_menu,
    laundry_service,
    lockers,
    luggage_storage,
    manual_massage,
    massage,
    neck_massage,
    non_smoking_rooms,
    outdoor_surveillance,
    packed_lunches,
    paid_cleaning,
    paid_laundry,
    parking,
    pet_allowed,
    pool,
    public_areas_surveillance,
    restaurant,
    room_service,
    safe,
    security_alarm,
    shoe_shine,
    smoke_detectors,
    smoking_areas,
    spa_services,
    special_diet_menu,
    steam_room,
    sun_terrace,
    taxi_service,
    transfer_paid,
    wifi,
    wine_champagne
)