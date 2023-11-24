@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.foodninja.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodninja.R
import com.example.foodninja.ui.theme.MetallicOrange2
import com.example.foodninja.ui.theme.RichBlack3


@Composable
fun MenuItem(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    ic: Int,
    price: Int,
    onClick:()-> Unit = {}
) {

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(Color.White),
        shape = RoundedCornerShape(12.dp),
        onClick = {onClick()}
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
        ) {
           Row(
               verticalAlignment = Alignment.CenterVertically,
           ) {
               Row(
                   verticalAlignment = Alignment.CenterVertically,
                   modifier = Modifier.weight(8f),
               ) {
                   SquareImage(
                       imageRes = ic,
                       size = 64
                   )

                   SpacerWidth20()

                   Column(
                       verticalArrangement = Arrangement.Center
                   ){

                       TextLabelLarge(
                           text = title,
                           fontWeight = FontWeight.Bold,
                           fontSize = 15
                       )
                       TextLabelLarge(
                           text = subTitle,
                           fontSize = 14,
                           color = RichBlack3
                       )
                   }


               }

               Box(
                   modifier = Modifier.weight(3f),
               ) {
                   Text(
                       modifier = Modifier.fillMaxWidth(),
                       text = "$$price",
                       fontWeight = FontWeight.Bold,
                       color = MetallicOrange2,
                       textAlign = TextAlign.Center,
                       fontSize = 22.sp,
                       maxLines = 1,
                       minLines = 1
                   )
               }

           }


        }
    }


}




@Preview
@Composable
fun MenuItemPreview() {
    MenuItem(
        title = "Herbal Pancake",
        subTitle = "Warung Herbal",
        ic = R.drawable.ic_menu1,
        price = 12,
    )
}