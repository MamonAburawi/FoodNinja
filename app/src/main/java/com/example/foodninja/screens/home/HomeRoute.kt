package com.example.foodninja.screens.home

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.foodninja.utils.popToExcept


private const val ROUTE = "Home"

fun NavController.navigateToHome() {
    navigate(ROUTE)
}

fun NavController.navigateToHomeRemoveAllBack() {
    popToExcept(ROUTE)
}


fun NavGraphBuilder.homeRoute(navController: NavController) {
    composable( route = ROUTE ) { Home( navController = navController ) }
}


class HomeArgs(savedStateHandle: SavedStateHandle){
    companion object {

    }
}

