@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.foodninja.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodninja.R
import com.example.foodninja.ui.theme.*


@Composable
fun RestaurantItem(
    title: String,
    distantInMin: Int,
    ic: Int,
    onClick:()-> Unit = {}
) {

    Card(
        colors = CardDefaults.cardColors(Color.White),
        onClick = {onClick()}
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                modifier = Modifier.size(100.dp, 100.dp),
                painter = painterResource(id = ic),
                contentDescription = ""
            )

            SpacerHeight5()

            TextLabelLarge(
                text = title,
                fontWeight = FontWeight.Bold,
                fontSize = 16
            )

            SpacerHeight5()

            TextLabelLarge(
                text = "$distantInMin min",
                fontWeight = FontWeight.Normal,
                fontSize = 13,
                color = RichBlack3
            )
        }
    }
}

@Preview
@Composable
fun RestaurantItemPreview() {
    RestaurantItem(
        title = "Vegan Resto",
        distantInMin = 12,
        ic = R.drawable.ic_restaurant1
    )
}