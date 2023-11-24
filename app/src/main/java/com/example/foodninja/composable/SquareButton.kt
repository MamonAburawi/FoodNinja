@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.foodninja.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodninja.R
import com.example.foodninja.ui.theme.*


@Composable
fun SquareButton(
    modifier:Modifier = Modifier,
    alpha: Float = 0.8f,
    icon: Int,
    icSize: Int = 25,
    icTint: Color = MetallicOrange1,
    color: Color = MetallicOrange5,
    onClick:()-> Unit
) {
    Card(
        modifier = modifier
            .alpha(alpha)
            .size(45.dp),
        onClick = { onClick() },
        colors = CardDefaults.cardColors(color),
        shape = RoundedCornerShape(12.dp),
    ) {
          Box(
              modifier = modifier.fillMaxSize(),
              contentAlignment = Alignment.Center
          ){

              Icon(
                  modifier = Modifier
                      .padding(2.dp)
                      .size(icSize.dp),
                  painter = painterResource(id = icon),
                  contentDescription = "",
                  tint = icTint,
              )

          }


    }
}


@Preview
@Composable
fun BackButtonPreview() {
    SquareButton(
        icon = R.drawable.ic_back_arrow
    ){}
}