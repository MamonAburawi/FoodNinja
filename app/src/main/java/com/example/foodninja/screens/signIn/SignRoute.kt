package com.example.foodninja.screens.signIn

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

private const val ROUTE = "SignIn"

fun NavController.navigateToSignIn(){
    popBackStack()
    navigate(ROUTE)
}

fun NavController.navigateToSignInRemoveAllBack(){

}

fun NavGraphBuilder.signInRoute(navController: NavController){
    composable(route = ROUTE) { SignIn(navController = navController) }
}


class SignInArgs(savedStateHandle: SavedStateHandle){
    companion object {

    }
}

