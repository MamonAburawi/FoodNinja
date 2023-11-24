@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.foodninja.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import  com.example.foodninja.utils.Organized
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.foodninja.R
import com.example.foodninja.ui.theme.BlueLight
import com.example.foodninja.ui.theme.Cultured
import com.example.foodninja.utils.light


@Composable
fun IconButtonText(
    modifier: Modifier = Modifier,
    borderColor: Color = Cultured,
    contentOrganized: Organized = Organized.Vertical,
    title: String,
    color: Color = Color.White,
    icon: Int,
    onClick:()-> Unit
) {
    val height = if (contentOrganized == Organized.Horizontal ) 55.dp else 125.dp
    val iconSize = if (contentOrganized == Organized.Horizontal) 30.dp else 52.dp

    Card(
        modifier = modifier
            .light(BlueLight)
            .fillMaxWidth()
            .height(height),
        colors = CardDefaults.cardColors(color),
        border = BorderStroke(width = 1.dp, borderColor),
        shape = RoundedCornerShape(12.dp),
        onClick = {
            onClick()
        }
    ) {

     Box(
         contentAlignment = Alignment.Center,
         modifier = Modifier.fillMaxSize()
     ) {
         if (contentOrganized == Organized.Horizontal){
             Row(
                 modifier = Modifier.padding(12.dp),
                 horizontalArrangement = Arrangement.Center,
                 verticalAlignment = Alignment.CenterVertically
             ) {
                 ButtonContent(icon = icon, name = title, iconSize = iconSize)
             }
         }else {
             Column(
                 modifier = Modifier.padding(12.dp),
                 verticalArrangement = Arrangement.SpaceEvenly,
                 horizontalAlignment  = Alignment.CenterHorizontally
             ) {

                 ButtonContent(icon = icon, name = title, iconSize = iconSize)

             }
         }
     }


    }
}

@Composable
private fun ButtonContent(icon: Int, name: String, iconSize: Dp){

    Image(
        modifier = Modifier.size(iconSize),
        painter = painterResource(id = icon),
        contentDescription = "icon"
    )

    SpacerHeight10()
    SpacerWidth10()

    TextLabelMedium(
        text = name,
        fontSize = 14,
        fontWeight = FontWeight.Bold
    )

}

@Preview
@Composable
fun ButtonIconTextVerticalPreview() {
    IconButtonText(
        title = stringResource(R.string.google),
        icon = R.drawable.ic_google,
        contentOrganized = Organized.Horizontal
    ){}
}


@Preview
@Composable
fun ButtonIconTextHorizontalPreview() {
    IconButtonText(
        title = stringResource(R.string.from_gallery),
        icon = R.drawable.ic_gallery,
        contentOrganized = Organized.Vertical
    ){}
}


