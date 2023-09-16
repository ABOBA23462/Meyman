package com.example.meyman.data.remote

import com.example.meyman.core.Constant
import com.example.meyman.data.remote.apiservices.AdvertisingApiService
import com.example.meyman.data.remote.apiservices.BookingApiService
import com.example.meyman.data.remote.apiservices.ChooseRoomService
import com.example.meyman.data.remote.apiservices.HotelApiService
import com.example.meyman.data.remote.apiservices.LoginApiService
import com.example.meyman.data.remote.apiservices.RegisterApiService
import com.example.meyman.data.remote.apiservices.ReviewApiService
import com.example.meyman.data.remote.apiservices.RoomsApiService
import com.example.meyman.data.remote.apiservices.UserProfileApiService
import com.example.meyman.data.remote.apiservices.UsersApiService
import com.example.meyman.data.remote.apiservices.UsernameApiService
import com.example.meyman.data.remote.apiservices.VerifyApiService
import com.example.meyman.data.remote.interceptor.TokenInterceptor
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private val okHttpClient = OkHttpClient().newBuilder()
        .addInterceptor(provideLoggingInterceptor())
//        .addInterceptor(TokenInterceptor())
        .callTimeout(30, TimeUnit.SECONDS)
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .build()

    val gson = GsonBuilder().setLenient().create()

    val retrofitClient = Retrofit.Builder()
        .baseUrl(Constant.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    fun provideHotelApiServer(): HotelApiService {
        return retrofitClient.create(HotelApiService::class.java)
    }

    fun provideReviewApiServer(): ReviewApiService {
        return retrofitClient.create(ReviewApiService::class.java)
    }

    fun provideRoomsApiServer(): RoomsApiService {
        return retrofitClient.create(RoomsApiService::class.java)
    }

    fun provideUsernameApiServer(): UsernameApiService {
        return retrofitClient.create(UsernameApiService::class.java)
    }

    fun provideUsersApiServer(): UsersApiService {
        return retrofitClient.create(UsersApiService::class.java)
    }

    fun provideRegisterApiServer(): RegisterApiService {
        return retrofitClient.create(RegisterApiService::class.java)
    }

    fun provideChooseRoom(): ChooseRoomService {
        return retrofitClient.create(ChooseRoomService::class.java)
    }

    fun provideBooking(): BookingApiService {
        return retrofitClient.create(BookingApiService::class.java)
    }

    fun provideVerifyAccount(): VerifyApiService {
        return retrofitClient.create(VerifyApiService::class.java)

    }

    fun provideLogin(): LoginApiService {
        return retrofitClient.create(LoginApiService::class.java)
    }

    fun provideAdvertising(): AdvertisingApiService {
        return retrofitClient.create(AdvertisingApiService::class.java)

    }

    fun provideUserProfile(): UserProfileApiService {
        return retrofitClient.create(UserProfileApiService::class.java)
    }
}