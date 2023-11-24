package com.example.foodninja.utils


import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


fun Modifier.light(color: Color): Modifier {
    return shadow(
        elevation = 32.dp,
        spotColor = color,
        shape = RoundedCornerShape(16.dp),
        clip = true
    )
}


fun Context.showMessage(message: String){
    Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
}