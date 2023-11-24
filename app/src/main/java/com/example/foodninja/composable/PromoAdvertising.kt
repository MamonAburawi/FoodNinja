package com.example.foodninja.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodninja.R
import com.example.foodninja.ui.theme.VeryLightMalachiteGreen



@Composable
fun PromoAdvertising(
    modifier: Modifier = Modifier,
    title: String,
    image: Int,
    onClicked:()-> Unit = {}
) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(VeryLightMalachiteGreen),
    ) {
      Box(
          modifier = Modifier.fillMaxSize(),
          contentAlignment = Alignment.Center
      ){
          Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceEvenly,
          ) {
              Image(
                  modifier = Modifier.weight(0.5f),
                  painter = painterResource(image),
                  contentDescription = "icon ice cream"
              )
              Column(
                  modifier = Modifier
                      .weight(0.5f)
                      .padding(top = 15.dp, end = 15.dp, bottom = 15.dp)
              ) {

                  TextLabelLarge(text = title,
                      fontSize = 17,
                      fontWeight = FontWeight.Bold,
                      color = Color.White
                  )

                  SpacerHeight15()

                  SimpleButton(
                      modifier = Modifier.size(height = 40.dp, width = 90.dp),
                      text = stringResource(R.string.buy_now),
                      textColor = VeryLightMalachiteGreen,
                      color = Color.White,
                      textSize = 12,
                      cornerShape = RoundedCornerShape(8.dp),
                      onClick = {
                          onClicked()
                      }
                  )
              }

          }
      }
    }
}


@Preview
@Composable
fun PromoAdvertisingPreview() {
    PromoAdvertising(
        title = stringResource(R.string.special_deal_for_october),
        image =  R.drawable.ice_cream
    )
}