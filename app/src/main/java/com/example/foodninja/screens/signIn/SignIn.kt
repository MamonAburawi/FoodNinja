package com.example.foodninja.screens.signIn


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.foodninja.R
import com.example.foodninja.composable.*
import com.example.foodninja.screens.home.navigateToHome
import com.example.foodninja.screens.signUp.navigateToSignUp
import com.example.foodninja.screens.viaMethod.navigateToViaMethod
import com.example.foodninja.ui.theme.VeryLightMalachiteGreen
import com.example.foodninja.utils.Organized


@Composable
fun SignIn(navController: NavController) {
    val context = LocalContext.current
   
    SignInContainer(
        onSignUpClicked = {
            navController.navigateToSignUp()
        },
        onRestPassClicked = {
            navController.navigateToViaMethod()
        },
        onLoginClicked = {
           navController.navigateToHome()
        }
    )
}


@Composable
private fun SignInContainer(
    onSignUpClicked:() -> Unit = {},
    onLoginClicked:() -> Unit = {},
    onRestPassClicked:()-> Unit = {},
    onFacebookClicked:()->Unit = {},
    onGoogleClicked:() ->Unit = {}
) {
    Box(modifier = Modifier.fillMaxSize()) {
        val scrollState = rememberScrollState()
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        DrawBackgroundPattern(alpha = 0.7f)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(state = scrollState),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AppBrandLogo()

            SpacerHeight40()

            TextLabelLarge(
                text = stringResource(id = R.string.login_label),
                fontSize = 24,
                fontWeight = FontWeight.Bold
            )

            SpacerHeight20()

            ExpandToFit()

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()

            ) {
                TextField(
                    hint = stringResource(R.string.email),
                    text = email,
                    keyboardType = KeyboardType.Email,
                    onTextChange = {
                        email = it.trim()
                    },
                    imeAction = ImeAction.Next
                )

                SpacerHeight15()

                TextField(
                    hint = stringResource(R.string.password),
                    text = password,
                    keyboardType = KeyboardType.Password,
                    onTextChange = {
                        password = it.trim()
                    },
                    imeAction = ImeAction.Done
                )


                SpacerHeight20()


                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    TextLabelMedium(
                        modifier = Modifier
                            .clickable { onSignUpClicked() },
                        text = stringResource(R.string.sign_up),
                        fontSize = 16,
                        fontWeight = FontWeight.Bold,
                        color = VeryLightMalachiteGreen
                    )

                    SpacerWidth10()


                    TextLabelMedium(
                        text = stringResource(R.string.or_continue_with),
                        fontSize = 12,
                        fontWeight = FontWeight.Bold
                    )

                }
                SpacerHeight20()


                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {


                    IconButtonText(
                        contentOrganized = Organized.Horizontal,
                        modifier = Modifier.weight(0.5f),
                        title = stringResource(R.string.facebook),
                        icon = R.drawable.ic_facebook,
                        onClick = { onFacebookClicked() }
                    )

                    SpacerWidth20()

                    IconButtonText(
                        contentOrganized = Organized.Horizontal,
                        modifier = Modifier.weight(0.5f),
                        title = "Google",
                        icon = R.drawable.ic_google,
                        onClick = { onGoogleClicked() }
                    )

                }

                SpacerHeight15()

                TextButton(
                    modifier = Modifier,
                    text = stringResource(R.string.forgot_your_password),
                    color = VeryLightMalachiteGreen,
                    fontWeight = FontWeight.Bold,
                    onClick = {
                        onRestPassClicked()
                    }
                )

                SpacerHeight15()

                SimpleButton(
                    text = stringResource(R.string.login),
                    onClick = { onLoginClicked() }
                )
            }

        }

    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SignInPreview() {
    SignInContainer(
    )
}