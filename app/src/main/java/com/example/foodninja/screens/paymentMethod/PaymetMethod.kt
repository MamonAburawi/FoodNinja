package com.example.foodninja.screens.paymentMethod


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.foodninja.R
import com.example.foodninja.composable.*
import com.example.foodninja.screens.uploadPhoto.navigateToUploadPhoto
import com.example.foodninja.utils.back

@Composable
fun PaymentMethod(
    navController: NavController,
    viewModel: PaymentMethodViewModel = hiltViewModel()
) {

    val user = viewModel.user.collectAsState().value

    PaymentMethodContent(
        onNextClicked = {
            navController.navigateToUploadPhoto()
        },
        onBackClicked = {
            navController.back()
        }
    )

}

@Composable
fun PaymentMethodContent(
    onNextClicked: () -> Unit,
    onBackClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 25.dp, end = 25.dp, bottom = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        // app bar
        TopAppBar1(
            title = stringResource(R.string.payment_method),
            subTitle = stringResource(id = R.string.this_data_will_be_displayed_in_your_account_profile_for_security),
            onBackClicked = {onBackClicked()}
        )

        SpacerHeight40()


        // button paypal
        IconButton(
            icon = R.drawable.ic_paypal,
            onClick = {

            })

        SpacerHeight20()

        // visa button
        IconButton(

            icon = R.drawable.ic_visa,
            onClick = {

            })

        SpacerHeight20()


        // payoneer button
        IconButton(
            icon = R.drawable.ic_payoneer,
            onClick = {

            })

        SpacerHeight20()


        ExpandToFit()

        // button next
        SimpleButton(
            text = stringResource(id = R.string.next),
            onClick = {
                onNextClicked()
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PaymentMethodPreview() {
    PaymentMethodContent(
        onNextClicked = {},
        onBackClicked = {}
    )
}

