package com.example.foodninja.screens.resetPassword


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.foodninja.R
import com.example.foodninja.composable.*
import com.example.foodninja.screens.passwordSuccessNotification.navigateToPasswordSuccessNotification
import com.example.foodninja.utils.back

@Composable
fun ResetPassword(
    navController: NavController,
) {
    val context = LocalContext.current

    RestPasswordContent(
        onBackClicked = {
            navController.back()
        }
    ) {
        navController.navigateToPasswordSuccessNotification()
    }

}


@Composable
fun RestPasswordContent(
    onBackClicked: () -> Unit = {},
    onNextClicked: () -> Unit = {}
) {
    var pass by remember { mutableStateOf("") }
    var confirmPass by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(start = 25.dp, end = 25.dp, bottom = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        // app bar
        TopAppBar1(
            title = stringResource(R.string.reset_your_password_here),
            subTitle = stringResource(id = R.string.this_data_will_be_displayed_in_your_account_profile_for_security),
            onBackClicked = { onBackClicked() }
        )

        SpacerHeight30()


        // new password
        TextFieldPassword(
            hint = stringResource(R.string.new_password) ,
            pass = pass ,
            onPassChanged ={
                pass = it
            },
            imeAction = ImeAction.Next
        )


        SpacerHeight20()


        // confirm password
        TextFieldPassword(
            hint = stringResource(R.string.confirm_password) ,
            pass = confirmPass ,
            onPassChanged ={
                confirmPass = it
            },
            imeAction = ImeAction.Done
        )

        SpacerHeight50()

        ExpandToFit()


        // button next
        SimpleButton(
            text = stringResource(id = R.string.next),
            onClick = { onNextClicked() }
        )

    }

}
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ResetPasswordPreview() {
    RestPasswordContent( )
}
