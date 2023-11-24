package com.example.foodninja.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodninja.R
import com.example.foodninja.ui.theme.*

@Composable
fun ToggleButton(
    isChecked: Boolean = false,
    title: String,
    onCheckedChange:(Boolean) -> Unit
) {
    var checkState by remember{ mutableStateOf(isChecked) }
    val icon = if (checkState) R.drawable.ic_done else R.drawable.ic_unchecked
    val bgToggle = if (checkState) VeryLightMalachiteGreen else RichBlack4


    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        IconToggleButton(
            checked = isChecked,
            onCheckedChange = {
                onCheckedChange(it)
            }) {

            Card(
                modifier = Modifier.size(20.dp),
                shape = CircleShape,
                colors = CardDefaults.cardColors(bgToggle)
            ){
                IconButton(
                    onClick = {
                        checkState = !checkState
                    }
                ) {
                    Icon(
                        modifier = Modifier.size(15.dp),
                        painter = painterResource(id = icon),
                        contentDescription = "toggle button",
                        tint = Color.White
                    )
                }
            }
        }

        SpacerWidth10()

        TextLabelMedium(
            text = title,
            color = RichBlack3
        )
    }

}



@Preview(showBackground = true)
@Composable
fun ToggleButtonPreview() {
    ToggleButton(
        isChecked = false,
        title = stringResource(R.string.sign_up_toggle_1),
        onCheckedChange = {}
    )
}