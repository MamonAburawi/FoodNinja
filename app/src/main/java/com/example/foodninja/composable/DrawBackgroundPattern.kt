package com.example.foodninja.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.foodninja.R


@Composable
fun DrawBackgroundPattern(
    modifier: Modifier = Modifier,
    alpha: Float = 0.6f
) {
    Image(
        modifier = modifier
            .fillMaxWidth(),
        painter = painterResource(id = R.drawable.ic_pattern),
        contentDescription = "",
        alpha = (alpha)
    )

}


@Preview(showBackground = true)
@Composable
fun DrawBackgroundPatternPreview() {
    DrawBackgroundPattern()
}