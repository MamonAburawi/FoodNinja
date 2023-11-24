package com.example.foodninja.composable


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.foodninja.ui.theme.RichBlack1
import androidx.compose.material3.TextButton
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TextButton(
    modifier: Modifier = Modifier,
    text: String,
    fontSize: Int = 14,
    fontWeight: FontWeight = FontWeight.Normal,
    textAlign: TextAlign = TextAlign.Start,
    color: Color = RichBlack1,
    onClick:()-> Unit
) {

    TextButton(
        onClick = {onClick() },
    ){
        TextLabelMedium(
           modifier =  modifier,
            text = text,
            fontSize = fontSize,
            fontWeight = fontWeight,
            textAlign = textAlign,
            color = color,
        )
    }
}

@Preview
@Composable
fun TextButtonPreview() {
    TextButton(text = "already have an account?"){}
}