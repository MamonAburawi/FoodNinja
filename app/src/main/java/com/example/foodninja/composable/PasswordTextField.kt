package com.example.foodninja.composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodninja.R

@Composable
fun TextFieldPassword(
    hint: String,
    pass: String,
    imeAction: ImeAction = ImeAction.Next,
    startIcon: Int? = null,
    onPassChanged:(String)-> Unit

) {

    var showPassword by remember { mutableStateOf(true) }

    // Password
    TextField(
        hint = hint,
        text = pass,
        keyboardType = KeyboardType.Password,
        startIcon = startIcon,
        endIcon = if (showPassword) R.drawable.ic_inactive_eye else R.drawable.ic_active_eye,
        onTextChange = {
            onPassChanged(it.trim())
        },
        imeAction = imeAction,
        visualTransformation = if (showPassword) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        }
    ) {
        showPassword = !showPassword
    }
}

@Preview
@Composable
fun TextFieldPasswordPreview(){
    TextFieldPassword(
        hint = stringResource(id = R.string.password),
        pass = "",
        startIcon = R.drawable.ic_lock,
        onPassChanged = {}
    )
}