package com.miqbalkalevi.simpleofflinecaching.features.restaurants

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.miqbalkalevi.simpleofflinecaching.R
import com.miqbalkalevi.simpleofflinecaching.databinding.FragmentRestaurantsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RestaurantsFragment : Fragment(R.layout.fragment_restaurants) {

    private val viewModel by viewModels<RestaurantsViewModel>()
    private var _binding: FragmentRestaurantsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentRestaurantsBinding.bind(view)

        val restaurantAdapter = RestaurantAdapter()

        binding.apply {
            rvRestaurants.apply {
                adapter = restaurantAdapter
                setHasFixedSize(true)
                itemAnimator = null
            }

            viewModel.restaurants.observe(viewLifecycleOwner) { restaurants ->
                restaurantAdapter.submitList(restaurants)
            }
        }

    }
}