package com.example.foodninja.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.foodninja.R
import com.example.foodninja.composable.*
import com.example.foodninja.data.*
import com.example.foodninja.screens.filter.navigateToFilter
import com.example.foodninja.ui.theme.MetallicOrange2
import com.example.foodninja.utils.DataType

@Composable
fun Home(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel()
) {

    val data = viewModel.restaurant.collectAsState().value
    val promo = viewModel.promo.collectAsState().value

    HomeContent(
        data,
        promo,
        onFilterOptionClicked = {
            navController.navigateToFilter()
        }
    )

}


@Composable
fun HomeContent(
    data: List<Restaurant> = listOf(),
    promo: Promo? = null,
    onFilterOptionClicked:()-> Unit = {}
) {
    var search by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {

        TopAppBar2 (
            modifier = Modifier.padding(start = 20.dp, end = 20.dp, bottom = 10.dp),
            title = search,
            hintSearch = stringResource(id = R.string.what_do_you_want_to_order),
            onFilterClicked = {
                onFilterOptionClicked()
            },
            onSearchChange = {
                search = it
            }
        )

        ComplexList(
            list = data,
            promo = promo,
            onShowMoreClicked = { dataType, name ->

            }
        )


    }

}


@Composable
fun ComplexList(
    list: List<Restaurant>,
    promo: Promo? = null,
    onShowMoreClicked: (DataType,String) -> Unit = { type, sectionName  -> },
) {

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues( bottom = 20.dp, top = 20.dp)
    ) {

            banner(promo)

            restaurantRow (
                list = list,
                headerName = "Nearest Restaurant",
                onItemClicked = {},
                onSectionClicked = { type, name ->
                    onShowMoreClicked(type, name)
                },
            )

            menu(
                headerName = "Popular Menu",
                list = list.first().menu,
                onItemClicked = {},
                onSectionClicked = {},
            )



    }
}


private fun LazyListScope.banner(
    promo: Promo? = null
){
    if (promo != null){
        item {
            PromoAdvertising(
                modifier = Modifier.padding(horizontal = 20.dp),
                title = stringResource(id = R.string.special_deal_for_october),
                image = R.drawable.ice_cream
            )
        }
    }
}


private fun LazyListScope.menu(
    headerName: String,
    list: List<Menu> = listOf(),
    onItemClicked:()-> Unit = {},
    onSectionClicked:() -> Unit = {}
) {
    item {
        Header(
            title = headerName,
            onClicked = { onSectionClicked() }
        )
    }
    itemsIndexed(list) {index, data ->
        MenuItem(
            modifier = Modifier.padding(horizontal = 20.dp),
            title = data.title,
            subTitle = data.subTitle,
            ic = data.ic,
            price = data.price,
            onClick = { onItemClicked() }
        )
    }
}


private fun LazyListScope.restaurantRow(
    headerName: String,
    list: List<Restaurant> = listOf(),
    onItemClicked: () -> Unit = {},
    onSectionClicked: (DataType,String) -> Unit
){
    item {
        Column {
            Header(
                title = headerName,
                onClicked = {
                    onSectionClicked( DataType.RESTAURANT, headerName )
                }
            )
            LazyRow(
                contentPadding = PaddingValues(vertical = 16.dp, horizontal = 10.dp),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ){
                itemsIndexed(items = list){index, data ->

                    RestaurantItem(
                        title = data.title,
                        distantInMin = data.distantInMin ,
                        ic = data.ic,
                        onClick = { onItemClicked() }
                    )

                }
            }
        }
    }
}



@Composable
private fun Header(
    title: String,
    onClicked: () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp)
    ) {
        TextLabelLarge(
            text = title,
            fontSize = 15,
            fontWeight = FontWeight.Bold
        )

        TextLabelLarge(
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .clickable { onClicked() },
            text = stringResource(R.string.view_more),
            fontSize = 12,
            color = MetallicOrange2
        )

    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomePreview(){
    val list = ArrayList<Restaurant>()
    val menuList = ArrayList<Menu>()
    val promo = Promo("Special Deal For October", R.drawable.ice_cream)

    repeat(30) {
        repeat(6){ inside ->
            val menu =   Menu("Herbal Pancake $inside", "Warung Herbal", ic = R.drawable.ic_menu1,7)
            menuList.add(menu)
        }
        list.add(Restaurant( "Vegan Resto $it", ic = R.drawable.ic_restaurant1,12,menuList))
    }

    HomeContent(list,promo)
}
