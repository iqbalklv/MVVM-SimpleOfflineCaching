package com.miqbalkalevi.simpleofflinecaching.features.restaurants

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.miqbalkalevi.simpleofflinecaching.data.RestaurantRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RestaurantsViewModel @Inject constructor(
    private val repository: RestaurantRepository
) : ViewModel() {

    val restaurants = repository.getRestaurants().asLiveData()
}