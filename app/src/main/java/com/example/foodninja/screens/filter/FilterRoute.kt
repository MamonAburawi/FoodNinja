package com.example.foodninja.screens.filter

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "Filter"

fun NavController.navigateToFilter() {
    navigate(ROUTE)
}


fun NavGraphBuilder.filterRoute(navController: NavController) {
    composable( route = ROUTE ) { Filter( navController = navController ) }
}


class FilterArgs(savedStateHandle: SavedStateHandle){
    companion object {

    }
}

