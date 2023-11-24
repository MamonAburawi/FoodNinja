package com.example.foodninja.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.foodninja.screens.filter.filterRoute
import com.example.foodninja.screens.home.homeRoute
import com.example.foodninja.screens.onBoarding.onBoardingRoute
import com.example.foodninja.screens.passwordSuccessNotification.passwordSuccessNotificationRoute
import com.example.foodninja.screens.paymentMethod.paymentMethodRoute
import com.example.foodninja.screens.resetPassword.restPasswordRoute
import com.example.foodninja.screens.setLocation.setLocationRoute
import com.example.foodninja.screens.signIn.signInRoute
import com.example.foodninja.screens.signUp.signUpRoute
import com.example.foodninja.screens.signUpProcess.signUpProcessRoute
import com.example.foodninja.screens.signUpSuccessNoification.signUpSuccessNotification
import com.example.foodninja.screens.uploadPhoto.uploadPhoto
import com.example.foodninja.screens.verificationCode.verificationCode
import com.example.foodninja.screens.viaMethod.viaMethodRoute


@Composable
fun FoodNinjaNavGraph(navController: NavHostController, startDestination: String) {
    NavHost(navController = navController, startDestination = startDestination ) {

        onBoardingRoute(navController)
        signUpRoute(navController)
        signInRoute(navController)
        signUpProcessRoute(navController)
        paymentMethodRoute(navController)
        uploadPhoto(navController)
        setLocationRoute(navController)
        signUpSuccessNotification(navController)
        verificationCode(navController)
        viaMethodRoute(navController)
        restPasswordRoute(navController)
        passwordSuccessNotificationRoute(navController)
        homeRoute(navController)
        filterRoute(navController)

    }
}


fun NavController.back(){
    navigateUp()
}

// this function will remove all backstack except the destination
fun NavController.popToExcept(destination: String) {
    popBackStack(
        destination,
        inclusive = false
    )
}





@Preview(showBackground = true, showSystemUi = true)
@Composable
fun NavGraphPreview() {
   FoodNinjaNavGraph(
       navController = rememberNavController(),
       startDestination = "OnBoarding"
   )
}