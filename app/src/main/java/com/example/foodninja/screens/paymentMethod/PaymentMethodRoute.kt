package com.example.foodninja.screens.paymentMethod

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.foodninja.data.User
import com.example.foodninja.utils.fromJson


private const val ROUTE = "PaymentMethod"

fun NavController.navigateToPaymentMethod(data: User = User()){
    val userString = data.toJson()
    navigate("${ROUTE}/${userString}")
}

fun NavGraphBuilder.paymentMethodRoute(navController: NavController) {
    composable(
        route = "$ROUTE/{${PaymentMethodArgs.USER_ARG}}",
        arguments = listOf(
            navArgument(PaymentMethodArgs.USER_ARG) { type = NavType.StringType } // pass json string object
        )
    ) { PaymentMethod(navController = navController) }
}

class PaymentMethodArgs(savedStateHandle: SavedStateHandle) {
    val jsonString: String = checkNotNull(savedStateHandle[USER_ARG])
    val user = jsonString.fromJson(User::class.java)


    companion object {
        const val USER_ARG: String = "User"
    }

}
