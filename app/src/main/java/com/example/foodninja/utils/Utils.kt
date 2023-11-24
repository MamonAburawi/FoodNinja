package com.example.foodninja.utils

import android.annotation.SuppressLint
import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.util.Date

enum class Organized { Horizontal , Vertical }
enum class RangeType { FIRST, LAST }
enum class MethodType { PHONE, EMAIL}
enum class DataType {RESTAURANT, MENU, NONE}


object OtpConfiguration {
    const val EXPIRED_OTP_TIME = 120000L // 2 min
}

// this function will convert the number to star
fun convertToStar(phoneNumber: String, range: RangeType): String {

    val rangeStart = when (range) {
        RangeType.FIRST-> 0
        RangeType.LAST -> phoneNumber.length - 4
        else -> throw IllegalArgumentException("Invalid range: $range")
    }

    val rangeEnd = rangeStart + 4

    return phoneNumber.mapIndexed { index, digit ->
        if (index in rangeStart until rangeEnd) "*" else digit
    }.joinToString("")
}

@SuppressLint("SimpleDateFormat")
fun longToDate(l: Long) = SimpleDateFormat("mm:ss").format(Date(l))

fun <A> String.fromJson(type: Class<A>): A {
    return Gson().fromJson(this, type)
}

fun <A> A.toJson(): String? {
    return Gson().toJson(this)
}


val locationFilter = listOf("10 KM", ">10 KM", "<10 KM")
val typeFilter = listOf("Restaurant", "Menu")
val foodType = listOf("Cake","Soup","Main Course","Appetizer", "Dessert")



