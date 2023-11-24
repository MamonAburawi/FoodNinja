@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)

package com.example.foodninja.screens.filter

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.foodninja.R
import com.example.foodninja.composable.*
import com.example.foodninja.ui.theme.*
import com.example.foodninja.utils.*

@Composable
fun Filter(
    navController: NavController
) {
    FilterContent()
}


@Composable
fun FilterContent() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp)
    ) {


        TopAppBar2(
            title = stringResource(id = R.string.find_your_favorite_food),
            hintSearch = stringResource(id = R.string.what_do_you_want_to_order),
            enableFilter = false,
            onSearchChange = {

            }
        )

        FilterSection(
            name = "Type",
            list = typeFilter,
            onClickItem = {

            }
        )

        SpacerHeight20()

        FilterSection(
            name = "Location",
            list = locationFilter,
            onClickItem = {

            }
        )

        SpacerHeight20()


        FilterSection(
            name = "Food",
            list = foodType,
            onClickItem = {

            }
        )



    }

}


@Composable
fun FilterSection(
    name: String,
    list: List<String>,
    onClickItem:(String)-> Unit = {}
) {

    var indexSelected by remember{ mutableIntStateOf(0) }
    val context = LocalContext.current

    Column {

        TextLabelLarge(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 16
        )

        SpacerHeight15()

        FlowRow(
            horizontalArrangement = Arrangement.spacedBy(18.dp),
            verticalArrangement = Arrangement.spacedBy(15.dp)
        ) {

            list.forEachIndexed { index, s ->
                FilterItem(
                    item = s,
                    isSelected = index == indexSelected,
                    onClick = {
                        indexSelected = index
                        onClickItem(s)
                    }
                )
            }

        }
    }

}

@Composable
private fun FilterItem(
    item: String,
    isSelected: Boolean = false,
    onClick:()-> Unit = {}
) {
    val color = if (isSelected) BrightYellow3 else MetallicOrange5
    val textColor = if (isSelected) RichBlack1 else MetallicOrange2
    Card(
        colors = CardDefaults.cardColors(color),
        onClick = { onClick() },
    ) {
        TextLabelLarge(
            modifier = Modifier.padding(5.dp),
            text = item,
            color = textColor,
            fontWeight = FontWeight.Bold,
            fontSize = 15
        )
    }
}

@Preview
@Composable
fun FilterItemPreview() {

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun FilterPreview() {
    FilterContent()
}