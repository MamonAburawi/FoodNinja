package com.example.foodninja.screens.home


import androidx.lifecycle.ViewModel
import com.example.foodninja.R
import com.example.foodninja.data.Menu
import com.example.foodninja.data.Promo
import com.example.foodninja.data.Restaurant
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(): ViewModel() {

    private val _restaurants = MutableStateFlow(listOf<Restaurant>())
    val restaurant = _restaurants.asStateFlow()

    private val _promo = MutableStateFlow(Promo())
    val promo = _promo.asStateFlow()

    init {

        val promo = Promo("Special Deal For October", R.drawable.ice_cream)

        val menuData = listOf(
            Menu("Herbal Pancake", "Warung Herbal", ic = R.drawable.ic_menu1,7),
            Menu("Fruit Salad", "Wjgie Resto", ic = R.drawable.ic_menu2,5),
            Menu("Green Noddle", "Noodle Home", ic = R.drawable.ic_menu1,15)
        )

        val restaurantData = listOf(
            Restaurant( "Vegan Resto", ic = R.drawable.ic_restaurant1,12,menuData),
            Restaurant( "Smart Resto", ic = R.drawable.ic_restaurant2,18,menuData),
            Restaurant( "Healthy Food", ic = R.drawable.ic_restaurant3,5,menuData),
            Restaurant( "Good Food", ic = R.drawable.ic_restaurant4,22,menuData),
            Restaurant( "Vegan Resto", ic = R.drawable.ic_restaurant5,15,menuData),
            Restaurant( "Smart Resto", ic = R.drawable.ic_restaurant6,7,menuData)
        )

        _restaurants.value = restaurantData
        _promo.value = promo
    }


}