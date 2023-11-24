package com.example.foodninja.screens.passwordSuccessNotification

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


private const val ROUTE = "PasswordSuccessNotification"

fun NavController.navigateToPasswordSuccessNotification(){
    popBackStack()
    navigate(ROUTE)
}

fun NavGraphBuilder.passwordSuccessNotificationRoute(navController: NavController){
    composable(route = ROUTE) { PasswordSuccessNotification(navController = navController) }
}


class PasswordSuccessNotificationRouteArgs(savedStateHandle: SavedStateHandle){
    companion object {

    }
}

