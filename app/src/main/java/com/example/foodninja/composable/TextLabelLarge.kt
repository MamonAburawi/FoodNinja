package com.example.foodninja.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodninja.ui.theme.RichBlack1
import com.example.foodninja.ui.theme.VeryLightMalachiteGreen

@Composable
fun TextLabelLarge(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: Int = 25,
    fontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = RichBlack1,
    enableUnderLine: Boolean = false
) {

    val lineWidth = (text.length * 7.5).dp


    Column(modifier = modifier) {
        Text(
            modifier = modifier,
            text = text,
            style = MaterialTheme.typography.titleLarge,
            color = color,
            fontWeight = fontWeight,
            fontSize = fontSize.sp,
            textAlign = textAlign
        )

        if (enableUnderLine){
            Divider(
                modifier = Modifier.width(lineWidth),
                color = color,
                thickness = 0.5.dp
            )
        }
    }


}


@Preview
@Composable
fun TextLabelLargePreview() {
    TextLabelLarge(
        text = "How are you?"
    )
}