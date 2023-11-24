package com.example.foodninja.screens.verificationCode

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


private const val ROUTE = "VerificationCode"

fun NavController.navigateToVerificationCode(){
    navigate(ROUTE)
}

fun NavGraphBuilder.verificationCode(navController: NavController){
    composable(route = ROUTE) { VerificationCode(navController = navController) }
}

class VerificationCodeRouteArgs(savedStateHandle: SavedStateHandle){
    companion object {

    }
}
