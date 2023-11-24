package com.example.foodninja.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodninja.R
import com.example.foodninja.ui.theme.*


@Composable
fun AppBrandLogo(
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = modifier.height(165.dp),
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = "icon logo"
            )

            Text(
                text = stringResource(R.string.food_ninja),
                style = MaterialTheme.typography.titleLarge,
                color = VeryLightMalachiteGreen,
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp
            )
            Text(
                text = stringResource(R.string.delivery_favorite_food),
                style = MaterialTheme.typography.titleLarge,
                color = RichBlack1,
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp
            )
        }
    }

}

@Preview
@Composable
fun AppBrandLogoPreview() {
    AppBrandLogo()
}