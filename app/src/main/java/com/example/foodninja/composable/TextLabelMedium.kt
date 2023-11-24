package com.example.foodninja.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodninja.ui.theme.RichBlack1
import com.example.foodninja.ui.theme.VeryLightMalachiteGreen

@Composable
fun TextLabelMedium(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: Int = 15,
    fontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = RichBlack1,
) {

    Column {
        Text(
            modifier = modifier,
            text = text,
            style = MaterialTheme.typography.titleMedium,
            color = color,
            fontWeight = fontWeight,
            fontSize = fontSize.sp,
            textAlign = textAlign
        )


    }

}

@Preview
@Composable
fun TextLabelMediumPreview() {
    TextLabelMedium(
        text = "How are you?",
        color = VeryLightMalachiteGreen
    )
}