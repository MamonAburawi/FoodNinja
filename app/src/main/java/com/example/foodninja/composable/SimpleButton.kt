@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.foodninja.composable

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodninja.R
import com.example.foodninja.ui.theme.*


@Composable
fun SimpleButton(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = Color.White,
    textSize: Int = 16 ,
    color: Color = VeryLightMalachiteGreen,
    cornerShape: RoundedCornerShape = RoundedCornerShape(12.dp),
    onClick:()-> Unit
) {

    Box(
        modifier = modifier
    ) {
        Card(
            modifier = Modifier,
            colors = CardDefaults.cardColors(color),
            shape = cornerShape,
            onClick = { onClick() }
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = modifier
                    .size(width = 160.dp, height = 55.dp)

            ) {

                TextLabelMedium(
                    text = text,
                    fontWeight = FontWeight.Bold,
                    color = textColor,
                    fontSize = textSize
                )

            }
        }
    }


}

@Preview
@Composable
fun ButtonPreview(){
    SimpleButton(text = stringResource(id = R.string.next)) {}
}