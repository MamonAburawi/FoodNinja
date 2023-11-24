@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.foodninja.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.TextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.foodninja.R
import com.example.foodninja.ui.theme.BlueLight
import com.example.foodninja.ui.theme.Cultured
import com.example.foodninja.ui.theme.RichBlack1
import com.example.foodninja.ui.theme.RichBlack4
import com.example.foodninja.utils.light


@Composable
fun TextField(
    modifier: Modifier = Modifier,
    hint: String = "",
    text: String = "",
    color: Color = Color.White,
    fontColor: Color = RichBlack1,
    hintFontColor: Color = Color.LightGray,
    keyboardType: KeyboardType = KeyboardType.Text,
    onTextChange:(String) -> Unit,
    startIcon: Int? = null,
    endIcon: Int? = null,
    fontSize: Int = 15,
    imeAction: ImeAction = ImeAction.Next,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onEndIconClicked:()-> Unit = {}
) {

    TextField(
        modifier = modifier
            .fillMaxWidth()
            .light(BlueLight)
            .clip(RoundedCornerShape(20.dp))
            .height(55.dp)
            .focusable(false),
        value = text,
        textStyle = TextStyle.Default.copy(
            fontSize = fontSize.sp,
            color = fontColor
        ),
        placeholder = {
            TextLabelMedium(
                text = hint,
                color = hintFontColor,
                fontSize = fontSize
            )},
        onValueChange = {
            onTextChange(it)
        },
        leadingIcon = {
            if (startIcon != null) {
                Image(
                    modifier = modifier
                        .size(25.dp),
                    painter = painterResource(startIcon),
                    contentDescription = "start icon"
                )
            }
        },
        trailingIcon = {
            if (endIcon != null) {
                IconButton(
                    modifier = modifier
                        .size(25.dp),
                    onClick = {
                        onEndIconClicked()
                    }
                ){
                    Image(
                        painter = painterResource(endIcon),
                        contentDescription = "end icon"
                    )
                }
            }
        },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        colors = TextFieldDefaults.colors(
            focusedTextColor = RichBlack4,
            cursorColor = RichBlack4,
            focusedContainerColor = color,
            unfocusedContainerColor = color ,
            disabledContainerColor = color,
            unfocusedSupportingTextColor = Cultured,
            focusedSupportingTextColor = Color.LightGray,
            focusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
        ),
        visualTransformation = visualTransformation
    )




}



@Preview
@Composable
fun TextFieldPreview(
) {
    TextField(
        modifier = Modifier,
        hint = "Password",
        text = "",
        startIcon = R.drawable.ic_lock,
        endIcon = R.drawable.ic_active_eye,
        onTextChange = {},
        color = Color.White
    ) {}


}



//
//
//@Composable
//fun TextFieldIcon(
//    modifier: Modifier = Modifier,
//    hint: String = "",
//    text: String = "",
//    keyboardType: KeyboardType = KeyboardType.Text,
//    onTextChange:(String) -> Unit,
//    startIcon: Int,
//    endIcon: Int? = null
//) {
//
//    var mText by remember { mutableStateOf(text) }
//    val isEmpty = mText.isEmpty()
//
//    Card(
//        modifier = modifier
//            .fillMaxWidth(),
//        border = BorderStroke(1.dp, Cultured),
//        colors = CardDefaults.cardColors(Color.White),
//        shape = RoundedCornerShape(16.dp),
//        elevation = CardDefaults.cardElevation(0.dp)
//
//    ) {
//        Box(
//            modifier = modifier
//                .fillMaxWidth()
//                .background(Color.Transparent)
//                .padding(horizontal = 20.dp)
//                .height(60.dp),
//            contentAlignment = Alignment.CenterStart
//        ){
//            Row(
//                modifier = modifier
//                    .fillMaxWidth()
//                    .align(Alignment.Center),
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//
//                Image(
//                   modifier =  modifier.height(35.dp)
//                        .weight(1f),
//                    painter = painterResource(id = startIcon),
//                    contentDescription = "start Icon"
//                )
//
//                Box(
//                    modifier.weight(6f)
//                ) {
//                    BasicTextField(
//                        modifier = modifier
//                            .fillMaxWidth(),
//                        value = text,
//                        onValueChange = {
//                            onTextChange(it)
//                        },
//                        keyboardOptions = KeyboardOptions(
//                            keyboardType = keyboardType
//                        )
//                    )
//
//                    if (isEmpty){
//                        TextLabelMedium(
//                            text = hint,
//                            fontSize = 18,
//                            color = RichBlack4
//                        )
//                    }
//                }
//
//
//                if (endIcon != null){
//                    Image(
//                        modifier =  modifier.height(35.dp)
//                            .weight(0.7f),
//                        painter = painterResource(id = endIcon),
//                        contentDescription = "start Icon"
//                    )
//                }
//
//
//
//
//            }
//
//
//        }
//    }
//
//}
//
//@Preview
//@Composable
//fun TextFieldIconPreview(
//) {
//    TextFieldIcon(
//        modifier = Modifier,
//        hint = "Enter Your Name",
//        text = "",
//        startIcon = R.drawable.ic_email,
//        endIcon = R.drawable.ic_active_eye,
//        onTextChange = {
//
//        }
//    )
//}