package com.example.foodninja.screens.uploadPhoto

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable


private const val ROUTE = "UploadPhoto"

fun NavController.navigateToUploadPhoto(){
    navigate(ROUTE)
}

fun NavGraphBuilder.uploadPhoto(navController: NavController){
    composable(route = ROUTE) { UploadPhoto(navController = navController) }
}


class UploadPhotoRouteArgs(savedStateHandle: SavedStateHandle){
    companion object {

    }
}
