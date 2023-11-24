package com.example.foodninja.screens.signUpProcess

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.foodninja.data.User
import com.example.foodninja.screens.paymentMethod.PaymentMethodArgs
import com.example.foodninja.screens.signUpProcess.SignUpProcessArgs.Companion.USER_ARG
import com.example.foodninja.utils.fromJson
import com.example.foodninja.utils.toJson


// NOTE: you have to set the argument that you want display it inside this screen

private const val ROUTE = "SignUpProcess"

fun NavController.navigateToSignUpProcess(data: User = User()) {
    val userString = data.toJson()
    navigate("${ROUTE}/${userString}")
}

fun NavGraphBuilder.signUpProcessRoute(navController: NavController){

    composable(
        route = "${ROUTE}/{${USER_ARG}}",
        arguments = listOf(
            navArgument(USER_ARG) { type = NavType.StringType } // pass json string object
        )
    ) { SignUpProcess(navController = navController) }
}



class SignUpProcessArgs(savedStateHandle: SavedStateHandle){
    val jsonString: String = checkNotNull(savedStateHandle[USER_ARG])
    val user = jsonString.fromJson(User::class.java)

    companion object {
        const val USER_ARG: String = "User"
    }
}