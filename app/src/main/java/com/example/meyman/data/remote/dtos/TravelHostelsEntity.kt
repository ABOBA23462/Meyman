package com.example.meyman.data.remote.dtos

data class TravelHostelsEntity(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<Hostel>
) {
    data class Hostel(
        val accommodation_type: String,
        val bathrooms: Int,
        val bed_type: String,
        val bedrooms: String,
        val beds: Int,
        val description: String,
        val food_type: String,
        val housing_amenities: HousingAmenities,
        val housing_name: String,
        val housing_type: String,
        val id: Int,
        val image: String,
        val location: String,
        val price_per_night: String,
        val room_amenities: RoomAmenities
    ) {
        data class HousingAmenities(
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

        data class RoomAmenities(
            val accessible_to_disabled_guests: Boolean,
            val air_conditioner: Boolean,
            val bath_or_shower: Boolean,
            val bidet: Boolean,
            val bottled_water: Boolean,
            val cable_satellite_tv: Boolean,
            val city_view: Boolean,
            val clothes_hanger: Boolean,
            val coffee_teapot: Boolean,
            val complimentary_toiletries: Boolean,
            val connecting_rooms_available: Boolean,
            val dryer: Boolean,
            val electric_kettle: Boolean,
            val flat_screen_tv: Boolean,
            val folding_bed: Boolean,
            val fridge: Boolean,
            val garden_view: Boolean,
            val hair_dryer: Boolean,
            val heating: Boolean,
            val high_toilet: Boolean,
            val housing: Int,
            val id: Int,
            val iron: Boolean,
            val kitchen_utensils: Boolean,
            val laptop_safe_box: Boolean,
            val linen: Boolean,
            val microwave: Boolean,
            val minibar: Boolean,
            val private_bathroom: Boolean,
            val room_cleaning: Boolean,
            val room_service: Boolean,
            val safe: Boolean,
            val sitting_area: Boolean,
            val sofa_bed: Boolean,
            val telephone: Boolean,
            val toilet_paper: Boolean,
            val toilet_with_handles: Boolean,
            val tv: Boolean,
            val wake_up_service: Boolean,
            val wardrobe: Boolean,
            val washing_machine: Boolean,
            val work_desk: Boolean
        )
    }
}