package com.example.foodninja.screens.viaMethod

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "ViaMethod"

fun NavController.navigateToViaMethod() {
    navigate(ROUTE)
}

fun NavGraphBuilder.viaMethodRoute(navController: NavController){
    composable(
        route = ROUTE,
        ) { ViaMethod(navController = navController) }
}


class ViaMethodRouteRouteArgs(savedStateHandle: SavedStateHandle){
    companion object {

    }
}
