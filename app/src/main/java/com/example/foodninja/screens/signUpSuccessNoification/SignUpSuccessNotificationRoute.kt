package com.example.foodninja.screens.signUpSuccessNoification

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


private const val ROUTE = "SignUpSuccessNotification"

fun NavController.navigateToSignUpSuccessNotification(){
    popBackStack()
    navigate(ROUTE)
}

fun NavGraphBuilder.signUpSuccessNotification(navController: NavController){
    composable(route = ROUTE) { SignUpSuccessNotification(navController = navController) }
}


class SignUpSuccessNotificationRouteArgs(savedStateHandle: SavedStateHandle){
    companion object {

    }
}
