package com.example.foodninja.screens.onBoarding

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.foodninja.screens.passwordSuccessNotification.PasswordSuccessNotification

private const val ROUTE = "OnBoarding"

fun NavController.navigateToOnBoarding(){
    navigate(ROUTE)
}

fun NavGraphBuilder.onBoardingRoute(navController: NavController){
    composable(route = ROUTE) { OnBoarding(navController = navController) }
}


class OnBoardingRouteArgs(savedStateHandle: SavedStateHandle){
    companion object {

    }
}

