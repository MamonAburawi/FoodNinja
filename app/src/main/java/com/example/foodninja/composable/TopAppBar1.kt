package com.example.foodninja.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodninja.R

@Composable
fun TopAppBar1(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    onBackClicked:()-> Unit = {}
) {
    Box(
        modifier = modifier.fillMaxWidth()
    ){
        Image(
            painter = painterResource(
                id = R.drawable.ic_pattern2),
            contentDescription = ""

        )
        Column(
            modifier = modifier
                .padding(top = 30.dp)
        ) {

            SquareButton(
                icon = R.drawable.ic_back_arrow,
                onClick = { onBackClicked() }
            )

            SpacerHeight20()

            Column(
                modifier = modifier.width(280.dp)
            ) {
                TextLabelLarge(
                    text = title,
                    fontSize = 28,
                    fontWeight = FontWeight.Bold
                )

                SpacerHeight30()

                TextLabelMedium(
                    text = subTitle,
                    fontSize = 14,
                )


            }

        }

    }
}

@Preview(showBackground = true)
@Composable
fun TopAppBar1Preview() {
    TopAppBar1(
        title = stringResource(id = R.string.fill_in_your_bio_to_get_started),
        subTitle = stringResource(id = R.string.this_data_will_be_displayed_in_your_account_profile_for_security)
    )
}