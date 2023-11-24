package com.example.foodninja.screens.signUpSuccessNoification

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.foodninja.R
import com.example.foodninja.composable.SuccessNotification
import com.example.foodninja.screens.home.navigateToHome


@Composable
fun SignUpSuccessNotification(navController: NavController) {

    SignUpSuccessNotificationContent(
        onTryOrderClicked = {
            // todo: navigate to home screen
            navController.navigateToHome()
        }
    )
}

@Composable
fun SignUpSuccessNotificationContent(
    onTryOrderClicked:()-> Unit = {}
) {
    SuccessNotification(
        subTitle = stringResource(R.string.your_profile_is_ready_to_use),
        btnTitle = stringResource(R.string.try_order),
        onClick = { onTryOrderClicked() }
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpSuccessNotificationPreview() {
    SignUpSuccessNotificationContent()
}