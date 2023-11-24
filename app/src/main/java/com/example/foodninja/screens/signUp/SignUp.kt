package com.example.foodninja.screens.signUp



import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.foodninja.R
import com.example.foodninja.SharedViewModel
import com.example.foodninja.composable.DrawBackgroundPattern
import com.example.foodninja.composable.SimpleButton
import com.example.foodninja.composable.ExpandToFit
import com.example.foodninja.composable.AppBrandLogo
import com.example.foodninja.composable.SpacerHeight10
import com.example.foodninja.composable.SpacerHeight15
import com.example.foodninja.composable.SpacerHeight20
import com.example.foodninja.composable.SpacerHeight30
import com.example.foodninja.composable.SpacerHeight40
import com.example.foodninja.composable.SpacerHeight5
import com.example.foodninja.composable.TextButton
import com.example.foodninja.composable.TextField
import com.example.foodninja.composable.TextFieldPassword
import com.example.foodninja.composable.TextLabelLarge
import com.example.foodninja.composable.ToggleButton
import com.example.foodninja.data.User
import com.example.foodninja.screens.signIn.navigateToSignIn
import com.example.foodninja.screens.signUpProcess.navigateToSignUpProcess
import com.example.foodninja.ui.theme.VeryLightMalachiteGreen

@Composable
fun SignUp(
    navController: NavController,
    sharedViewModel: SharedViewModel = hiltViewModel()
) {


    SignUpContent(
        onCreateAccountClicked = { user ->
            sharedViewModel.updateUser(user)
            navController.navigateToSignUpProcess()
        },
        onHaveAccountClicked = {
            navController.navigateToSignIn()
        }
    )
  
}

@Composable
fun SignUpContent(
    onCreateAccountClicked:(User)-> Unit = {},
    onHaveAccountClicked:() -> Unit = {}
) {
    val scrollState = rememberScrollState()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var isEmailChecked by remember { mutableStateOf(false) }
    var isKeepLoginChecked by remember { mutableStateOf(false) }


    Box(
        modifier = Modifier.fillMaxSize()
    ) {

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
                text = stringResource(R.string.sign_up_label),
                fontSize = 24,
                fontWeight = FontWeight.Bold
            )

            SpacerHeight30()

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxSize()

            ) {


                // Email
                TextField(
                    hint = stringResource(id = R.string.email),
                    text = email,
                    keyboardType = KeyboardType.Email,
                    startIcon = R.drawable.ic_email,
                    onTextChange = {
                        email = it.trim()
                    }
                )

                SpacerHeight15()

                // password
                TextFieldPassword(
                    hint = stringResource(R.string.password) ,
                    pass = password,
                    onPassChanged ={
                        password = it
                    },
                    startIcon = R.drawable.ic_lock,
                    imeAction = ImeAction.Done
                )

                SpacerHeight5()

                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    ToggleButton(
                        isChecked = isKeepLoginChecked,
                        title = stringResource(id = R.string.sign_up_toggle_1),
                        onCheckedChange = {
                            isKeepLoginChecked = it
                        }
                    )


                    ToggleButton(
                        isChecked = isEmailChecked,
                        title = stringResource(R.string.sign_up_toggle_2),
                        onCheckedChange = {
                            isEmailChecked = it
                        }
                    )


                }


                ExpandToFit()

                SpacerHeight20()

                SimpleButton(
                    text = stringResource(R.string.create_account),
                    onClick = {
                        val user = User(
                            email = email,
                            password = password
                        )
                        onCreateAccountClicked(user)
                    }
                )

                SpacerHeight10()

                TextButton(
                    modifier = Modifier,
                    text = stringResource(R.string.already_have_an_account),
                    color = VeryLightMalachiteGreen,
                    fontWeight = FontWeight.Bold,
                    onClick = { onHaveAccountClicked() }
                )


            }


        }

    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SignSignPreview() {
    SignUpContent()
}