package com.example.foodninja.data

import androidx.annotation.DrawableRes

data class Restaurant(
    val title: String = "",
    @DrawableRes  val ic: Int = 0,
    val distantInMin: Int = 0,
    var menu: List<Menu> = listOf()
)
