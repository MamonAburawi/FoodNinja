package com.example.foodninja.data

import androidx.annotation.DrawableRes
import com.example.foodninja.utils.MethodType

data class ViaMethod(
    val title: String,
    val subTitle: String,
    val type: MethodType, // mobile or email
    @DrawableRes val icon: Int
)
