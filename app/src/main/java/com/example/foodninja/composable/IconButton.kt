@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.foodninja.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodninja.R
import com.example.foodninja.ui.theme.BlueLight
import com.example.foodninja.utils.light


@Composable
fun IconButton(
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    icon: Int,
    iconSize: Int = 90,
    onClick:()-> Unit
) {

    Card(
        modifier = modifier
            .light(BlueLight)
            .fillMaxWidth()
            .height(73.dp),
        colors = CardDefaults.cardColors(color),
        shape = RoundedCornerShape(16.dp),
        onClick = { onClick() }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Image(
                modifier = Modifier.size(iconSize.dp),
                painter = painterResource(id = icon),
                contentDescription = "icon"
            )


        }

    }
}

@Preview
@Composable
fun ButtonIconPreview() {
    IconButton( icon = R.drawable.ic_payoneer){}
}