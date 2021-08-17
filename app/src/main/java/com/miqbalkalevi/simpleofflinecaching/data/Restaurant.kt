package com.miqbalkalevi.simpleofflinecaching.data

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "restaurants")
@Parcelize
data class Restaurant(
	@PrimaryKey @NonNull val uid: String,
	val address: String? = null,
	val review: String? = null,
	val name: String? = null,
	val description: String? = null,
	val logo: String? = null,
	val phoneNumber: String? = null,
	val id: Int? = null,
	val type: String? = null
) : Parcelable
