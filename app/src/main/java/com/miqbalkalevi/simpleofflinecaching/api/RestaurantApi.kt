package com.miqbalkalevi.simpleofflinecaching.api

import com.miqbalkalevi.simpleofflinecaching.data.Restaurant
import retrofit2.http.GET
import retrofit2.http.Query

interface RestaurantApi {

    companion object {
        const val BASE_URL = "https://random-data-api.com/api/"
    }

    @GET("restaurant/random_restaurant")
    suspend fun getRestaurants(
        @Query("size") size: Int
    ): List<Restaurant>
}