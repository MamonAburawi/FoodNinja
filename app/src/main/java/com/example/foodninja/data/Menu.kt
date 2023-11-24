package com.example.foodninja.data

import androidx.annotation.DrawableRes

data class Menu(
    val title: String = "",
    val subTitle: String = "",
    @DrawableRes val ic: Int = 0,
    val price: Int
)
