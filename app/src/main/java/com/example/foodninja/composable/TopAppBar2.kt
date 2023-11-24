package com.example.foodninja.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.foodninja.R
import com.example.foodninja.ui.theme.*


@Composable
fun TopAppBar2(
    modifier: Modifier = Modifier,
    title: String,
    hintSearch: String,
    onFilterClicked:()-> Unit = {},
    enableFilter: Boolean = true,
    onSearchChange:(String) -> Unit
) {
    Box(
        modifier = modifier.fillMaxWidth()
    ){
        Image(
            painter = painterResource(
                id = R.drawable.ic_pattern2),
            contentDescription = ""
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
        ) {

            Box(
                modifier = Modifier.fillMaxWidth(),
            ) {
                TextLabelLarge(
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .width(230.dp),
                    text = hintSearch,
                    fontSize = 28,
                    fontWeight = FontWeight.Bold
                )

                NotifyBadge(
                    modifier = Modifier.align(Alignment.CenterEnd),
                    icon = R.drawable.ic_notification,
                ) {

                }

            }


            SpacerHeight20()

           Row(
               modifier = Modifier.fillMaxWidth()
                   .height(52.dp),
            verticalAlignment = Alignment.CenterVertically
           ) {
               TextField(
                   modifier = Modifier.weight(0.75f)
                       .fillMaxHeight(),
                   color = MetallicOrange5,
                   startIcon = R.drawable.ic_search,
                   hint = hintSearch,
                   text = title,
                   onTextChange = {
                       onSearchChange(it)
                   },
                   hintFontColor = MetallicOrange3,
                   fontColor = MetallicOrange3,
                   keyboardType = KeyboardType.Text
               )

               SpacerWidth10()

               if (enableFilter){
                   SquareButton(
                       modifier = Modifier.weight(0.155f)
                           .rotate(180f)
                           .fillMaxHeight(),
                       icon = R.drawable.ic_filter,
                       icSize = 30,
                       onClick = { onFilterClicked() }

                   )
               }



           }




        }

    }
}


@Preview(showBackground = true)
@Composable
fun TopAppBar2Preview() {
    TopAppBar2(
        title = stringResource(R.string.find_your_favorite_food),
        hintSearch = stringResource(R.string.what_do_you_want_to_order),
        onSearchChange = {}
    )
}
