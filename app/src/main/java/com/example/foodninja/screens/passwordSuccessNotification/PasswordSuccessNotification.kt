package com.example.foodninja.screens.passwordSuccessNotification

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodninja.R
import com.example.foodninja.composable.SuccessNotification
import com.example.foodninja.screens.signIn.navigateToSignInRemoveAllBack

@Composable
fun PasswordSuccessNotification(navController: NavController) {


    SuccessNotificationContent {
        navController.navigateToSignInRemoveAllBack()
    }

}

@Composable
fun SuccessNotificationContent(onBackClicked:()-> Unit) {
    SuccessNotification(
        subTitle = stringResource(R.string.password_reset_successful),
        btnTitle = stringResource(R.string.back),
        onClick = {
            onBackClicked()
        }
    )
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PasswordSuccessNotificationPreview() {
    PasswordSuccessNotification(rememberNavController())
}