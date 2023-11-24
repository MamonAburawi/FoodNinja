package com.example.foodninja.composable


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodninja.R
import com.example.foodninja.ui.theme.VeryLightMalachiteGreen

@Composable
fun SuccessNotification(
    modifier: Modifier = Modifier,
    title: String = stringResource(R.string.congrats),
    subTitle: String,
    btnTitle: String,
    onClick:() -> Unit
) {
    
    Box(
        modifier = modifier.fillMaxSize()
            .padding(bottom = 40.dp)
    ){
        Image(
            painter = painterResource(id = R.drawable.ic_pattern),
            contentDescription = "image pattern "
        )
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {


            Image(
                modifier = modifier.size(height = 160.dp, width = 170.dp),
                painter = painterResource(id = R.drawable.ic_success),
                contentDescription = "image pattern "
            )

            SpacerHeight20()

            TextLabelLarge(
                text = title,
                color = VeryLightMalachiteGreen,
                fontWeight = FontWeight.Bold,
                fontSize = 30
            )
            SpacerHeight20()

            TextLabelLarge(
                text = subTitle,
                fontWeight = FontWeight.Bold,
                fontSize = 23
            )


        }

        // button next
        SimpleButton(
            modifier = Modifier
                .align(Alignment.BottomCenter),
            text = btnTitle,
            onClick = { onClick() }
        )




    }




}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SignUpSuccessNotificationPreview() {
    SuccessNotification(
        subTitle = stringResource(R.string.your_profile_is_ready_to_use),
        btnTitle = stringResource(R.string.try_order),
        onClick = {}
    )
}