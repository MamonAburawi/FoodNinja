package com.example.foodninja.data

import android.os.Parcelable
import android.provider.CallLog.Locations
import androidx.annotation.DrawableRes
import com.example.foodninja.utils.fromJson
import com.example.foodninja.utils.toJson
import kotlinx.parcelize.Parcelize


@Parcelize
data class User(
    val id: String = "",
    val firstName: String = "",
    val lastName: String = "",
    val password: String = "",
    val phone: String = "",
    val email: String = "",
    val location: Location = Location(),
    @DrawableRes val imgProfile: Int = 0
): Parcelable{
    fun toJson() = mapOf(
        "id" to id,
        "firstName" to firstName,
        "lastName" to lastName,
        "password" to password,
        "phone" to phone,
        "email" to email,
        "imgProfile" to imgProfile
    ).toJson()

    @Parcelize
    data class Location(
        val lat: Int = 0,
        val long: Int = 0
    ): Parcelable

}
