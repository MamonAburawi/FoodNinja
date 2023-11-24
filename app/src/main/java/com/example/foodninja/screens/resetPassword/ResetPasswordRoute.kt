package com.example.foodninja.screens.resetPassword

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.foodninja.screens.passwordSuccessNotification.PasswordSuccessNotification
import com.example.foodninja.screens.paymentMethod.PaymentMethodArgs
import com.example.foodninja.screens.resetPassword.ResetPasswordRouteArgs.Companion.IS_NEW

private const val ROUTE = "RestPassword"

// isNew used for detect if the user trying to create a new account or just reset password
fun NavController.navigateToResetPassword(){
    popBackStack()
    navigate(ROUTE)
}

fun NavGraphBuilder.restPasswordRoute(navController: NavController){
    composable(
        route = ROUTE,
    ) { ResetPassword(navController = navController) }
}


class ResetPasswordRouteArgs(savedStateHandle: SavedStateHandle) {
    val isNew: Boolean = checkNotNull(savedStateHandle[IS_NEW])

    companion object {
        const val IS_NEW = "isNew"
    }
}
