package com.miqbalkalevi.simpleofflinecaching.features.restaurants

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.miqbalkalevi.simpleofflinecaching.api.RestaurantApi
import com.miqbalkalevi.simpleofflinecaching.data.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantsViewModel @Inject constructor(
    private val api: RestaurantApi
) : ViewModel() {

    private val restaurantsLiveData = MutableLiveData<List<Restaurant>>()
    val restaurants: LiveData<List<Restaurant>> = restaurantsLiveData

    init {
        viewModelScope.launch {
            val restaurants = api.getRestaurants(20)
            delay(2000)
            restaurantsLiveData.value = restaurants
        }
    }
}