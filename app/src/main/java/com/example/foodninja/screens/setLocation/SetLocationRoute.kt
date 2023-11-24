package com.example.foodninja.screens.setLocation

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


private const val ROUTE = "SetLocationNotification"

fun NavController.navigateToSetLocation(){
    navigate(ROUTE)
}

fun NavGraphBuilder.setLocationRoute(navController: NavController){
    composable(route = ROUTE) { SetLocation(navController = navController) }
}


class SetLocationRouteArgs(savedStateHandle: SavedStateHandle){
    companion object {

    }
}
