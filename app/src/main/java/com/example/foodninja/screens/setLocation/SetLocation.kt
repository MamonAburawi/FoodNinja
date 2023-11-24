package com.example.foodninja.screens.setLocation

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.foodninja.R
import com.example.foodninja.composable.*
import com.example.foodninja.screens.signUpSuccessNoification.navigateToSignUpSuccessNotification
import com.example.foodninja.ui.theme.*
import com.example.foodninja.utils.back
import com.example.foodninja.utils.light

@Composable
fun SetLocation(navController: NavController) {


    SetLocationContent(
        onBackClicked = {
            navController.back()
        },
        onNextClicked = {
            navController.navigateToSignUpSuccessNotification()
        },
        onSetLocationClicked = {
            // todo: get the your location user api and update share pref user
        }
    )
}

@Composable
fun SetLocationContent(
    onBackClicked:()-> Unit = {},
    onNextClicked:()-> Unit = {},
    onSetLocationClicked:()-> Unit = {}
) {

    var location by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 25.dp, end = 25.dp, bottom = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        // app bar
        TopAppBar1(
            title = stringResource(id = R.string.fill_in_your_bio_to_get_started),
            subTitle = stringResource(id = R.string.this_data_will_be_displayed_in_your_account_profile_for_security),
            onBackClicked = { onBackClicked() }
        )

        SpacerHeight30()


        Card(
            modifier = Modifier
                .fillMaxWidth()
                .light(BlueLight),
            colors = CardDefaults.cardColors(Color.White),
            shape = RoundedCornerShape(16.dp),
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(15.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        modifier = Modifier.size(35.dp),
                        painter = painterResource(id = R.drawable.ic_pin),
                        contentDescription = "icon pin"
                    )

                    SpacerWidth10()

                    TextLabelMedium(
                        text = "Your Location",
                        fontWeight = FontWeight.Bold
                    )
                }

                SpacerHeight30()

                SimpleButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = stringResource(R.string.set_location),
                    color = Cultured,
                    textColor = RichBlack1,
                    onClick = { onSetLocationClicked() }
                )
            }

        }

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
fun SetLocationPreview() {
    SetLocationContent()
}