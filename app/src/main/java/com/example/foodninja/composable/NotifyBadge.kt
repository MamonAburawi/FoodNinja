@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.foodninja.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodninja.R
import com.example.foodninja.ui.theme.MetallicOrange1
import com.example.foodninja.ui.theme.MetallicOrange3
import com.example.foodninja.ui.theme.VeryLightMalachiteGreen


@Composable
fun NotifyBadge(
    modifier: Modifier = Modifier,
    alpha: Float = 1f,
    icon: Int = R.drawable.ic_notification,
    icTint: Color = VeryLightMalachiteGreen,
    color: Color = Color.White,
    badgeColor: Color = Color.Red,
    badgeContent: String = "",
    onClick:()-> Unit
) {
    Box( modifier = modifier ) {
        Card(
            modifier = Modifier
                .alpha(alpha)
                .size(45.dp),
            onClick = { onClick() },
            colors = CardDefaults.cardColors(Color.Transparent),
            shape = RoundedCornerShape(12.dp),
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color),
                contentAlignment = Alignment.Center
            ){

                Box(
                    modifier = Modifier.align(Alignment.Center)
                ) {


                    Icon(
                        modifier = Modifier
                            .size(25.dp),
                        painter = painterResource(id = icon),
                        contentDescription = "",
                        tint = icTint,
                    )


                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .padding(end = 4.dp)
                                .clip(CircleShape)
                                .size(6.dp)
                                .background(badgeColor)
                                .align(Alignment.TopEnd),

                            content = {
                                if (badgeContent.isNotEmpty()) {
                                    Text(
                                        modifier = Modifier.padding(0.5.dp),
                                        textAlign = TextAlign.Center,
                                        text = badgeContent,
                                        fontSize = 4.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                }

                            }
                        )

                }

            }


        }
    }

}


@Preview
@Composable
fun NotifyBadgePreview() {
    NotifyBadge(
        icon = R.drawable.ic_notification,
        badgeContent = "5"
    ) {

    }
}