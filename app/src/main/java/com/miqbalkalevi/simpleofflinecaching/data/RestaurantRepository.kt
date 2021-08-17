package com.miqbalkalevi.simpleofflinecaching.data

import androidx.room.withTransaction
import com.miqbalkalevi.simpleofflinecaching.api.RestaurantApi
import com.miqbalkalevi.simpleofflinecaching.util.networkBoundResource
import kotlinx.coroutines.delay
import javax.inject.Inject

class RestaurantRepository @Inject constructor(
    private val api: RestaurantApi,
    private val db: RestaurantDatabase
) {

    private val restaurantDao = db.restaurantDao()

    fun getRestaurants() = networkBoundResource(
        query = {
            restaurantDao.getAllRestaurants()
        },
        fetch = {
            delay(2000)
            api.getRestaurants(20)
        },
        saveFetchResult = { restaurants ->
            db.withTransaction {
                restaurantDao.deleteAllRestaurants()
                restaurantDao.insertRestaurants(restaurants)
            }
        }
    )
}