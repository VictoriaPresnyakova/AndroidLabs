package com.example.androidlabs.api

import com.example.androidlabs.api.model.HotelRemote
import com.example.androidlabs.api.model.OrderRemote
import com.example.androidlabs.api.model.UserRemote
import com.example.androidlabs.api.model.UserRemoteSignIn
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface BackendService {

    //SNEAKER
    @GET("hotel/get/{id}")
    suspend fun getHotel(
        @Path("id") id: Int,
    ): HotelRemote

    @GET("hotel/getAll")
    suspend fun getHotels(
        @Query("page") page: Int,
        @Query("size") size: Int,
    ): List<HotelRemote>

    @POST("hotel/create")
    suspend fun createHotel(
        @Body hotel: HotelRemote,
    ): HotelRemote

    @PUT("hotel/update/{id}")
    suspend fun updateHotel(
        @Path("id") id: Int,
        @Body hotel: HotelRemote
    ): HotelRemote

    @DELETE("sneaker/delete/{id}")
    suspend fun deleteHotel(
        @Path("id") id: Int
    )

    //USER
    @POST("user/signup")
    suspend fun SignUp(
        @Body user: UserRemote,
    ): UserRemote

    @POST("user/signin")
    suspend fun SignIn(
        @Body user: UserRemoteSignIn
    ): UserRemote

    @POST("order/create")
    suspend fun createOrder(
        @Body order: OrderRemote
    ): Long

    @GET("order/getUserOrders/{userId}")
    suspend fun getUserOrders(
        @Path("userId") userId: Int
    ) : List<OrderRemote>

    @GET("order/getHotelFromOrder/{orderId}")
    suspend fun getHotelFromOrder(
        @Path("orderId") orderId: Int
    ) : HotelRemote

    @GET("order/deleteOrder/{orderId}")
    suspend fun deleteOrder(
        @Path("orderId") orderId: Int
    )

    companion object {
        private const val BASE_URL = "https://59k4pfj3-8080.euw.devtunnels.ms/api/"

        @Volatile
        private var INSTANCE: BackendService? = null

        fun getInstance(): BackendService {
            return INSTANCE ?: synchronized(this) {
                val logger = HttpLoggingInterceptor()
                logger.level = HttpLoggingInterceptor.Level.BASIC
                val client = OkHttpClient.Builder()
                    .addInterceptor(logger)
                    .build()
                return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
                    .build()
                    .create(BackendService::class.java)
                    .also { INSTANCE = it }
            }
        }
    }
}