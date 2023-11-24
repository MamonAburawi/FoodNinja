package com.example.foodninja.screens.signUp

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


// NOTE: you have to set the argument that you want display it inside this screen

private const val ROUTE = "SignUp"

fun NavController.navigateToSignUp(){
    navigate(ROUTE)
}

fun NavGraphBuilder.signUpRoute(navController: NavController){
    composable(route = ROUTE) { SignUp(navController = navController) }
}


class SignUpArgs(savedStateHandle: SavedStateHandle){
    companion object {

    }
}