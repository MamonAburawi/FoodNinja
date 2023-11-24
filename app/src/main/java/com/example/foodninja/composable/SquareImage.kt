package com.example.foodninja.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodninja.R


@Composable
fun SquareImage(
    modifier: Modifier = Modifier,
    imageRes: Int,
    size: Int = 100
) {

    Image(
        modifier = modifier
            .size(size.dp)
            .clip(RoundedCornerShape(16.dp)),
        painter = painterResource(imageRes),
        contentDescription = ""
    )


}

@Preview(showBackground = true)
@Composable
fun ImageProfilePreview() {
    SquareImage(
        imageRes = R.drawable.ic_photo_test
    )
}