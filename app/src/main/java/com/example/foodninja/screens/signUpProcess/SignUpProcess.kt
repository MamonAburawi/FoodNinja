package com.example.foodninja.screens.signUpProcess

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodninja.R
import com.example.foodninja.SharedViewModel
import com.example.foodninja.composable.*
import com.example.foodninja.data.User
import com.example.foodninja.screens.paymentMethod.navigateToPaymentMethod
import com.example.foodninja.utils.back


@Composable
fun SignUpProcess(
    navController: NavController,
    shareViewModel: SharedViewModel = hiltViewModel()
) {
    val user = shareViewModel.user.collectAsState()

    SignUpProcessContent(
        onBackClicked = {
            navController.back()
        },
        onNextClicked = {
           val updatedUser =  user.value.copy(
                firstName = it.firstName,
                lastName = it.lastName,
                phone = it.phone
            )
            navController.navigateToPaymentMethod(updatedUser)
            Log.d("SignUpProcess","updated user: $updatedUser")
        }
    )

}

@Composable
fun SignUpProcessContent(
    onBackClicked:()-> Unit = {},
    onNextClicked:(User)-> Unit = {}
) {

    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp)
            ) {

                // app bar
                TopAppBar1(
                    title = stringResource(id = R.string.fill_in_your_bio_to_get_started),
                    subTitle = stringResource(id = R.string.this_data_will_be_displayed_in_your_account_profile_for_security),
                    onBackClicked = { onBackClicked() }
                )

                SpacerHeight30()

                // first name
                TextField(
                    text = firstName,
                    onTextChange = {firstName = it},
                    hint = stringResource(R.string.first_name),
                    imeAction = ImeAction.Next
                )

                SpacerHeight20()

                // last name
                TextField(
                    text = lastName,
                    onTextChange = {lastName = it},
                    hint = stringResource(R.string.last_name),
                    imeAction = ImeAction.Next
                )

                SpacerHeight20()

                // phone
                TextField(
                    text = phone,
                    onTextChange = {phone = it},
                    hint = stringResource(R.string.mobile_number),
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Phone
                )

            }
            ExpandToFit()

            SpacerHeight40()

            // button next
            SimpleButton(
                text = stringResource(id = R.string.next),
                onClick = {
                    val user = User(
                        firstName = firstName,
                        lastName = lastName,
                        phone = phone
                    )
                    onNextClicked(user)
                }
            )

            SpacerHeight40()

        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SignUpProcessPreview() {
    SignUpProcessContent()
}