@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.foodninja.screens.viaMethod

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodninja.R
import com.example.foodninja.composable.*
import com.example.foodninja.data.ViaMethod
import com.example.foodninja.screens.verificationCode.navigateToVerificationCode
import com.example.foodninja.ui.theme.*
import com.example.foodninja.utils.*

@Composable
fun ViaMethod(
    navController: NavController
) {

    val maskedPhone = convertToStar((928748589).toString(),RangeType.FIRST)
    val maskedEmail = convertToStar("test.test@gmail.com", RangeType.FIRST)
    var showDialog by remember { mutableStateOf(false) }

    var method by remember { mutableStateOf(MethodType.PHONE.name) } // initial value

    val methods = listOf(
        ViaMethod(
            title = stringResource(R.string.via_sms),
            subTitle = maskedPhone,
            type = MethodType.PHONE,
            icon = R.drawable.ic_chat
        ),
        ViaMethod(
            title = stringResource(R.string.via_email),
            subTitle = maskedEmail,
            type = MethodType.EMAIL,
            icon = R.drawable.ic_email2
        )
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        // dialog
        if (showDialog){

            val title = stringResource(id = R.string.verify_info_dialog_title)

            val subTitle = if (method == MethodType.PHONE.name) stringResource(id = R.string.verify_info_dialog_phone_sub_title)
            else stringResource(id = R.string.verify_info_dialog_email_sub_title)

            val keyboardType = if(method == MethodType.PHONE.name) KeyboardType.Phone else KeyboardType.Email

            val hint = if (method == MethodType.PHONE.name) stringResource(id = R.string.mobile_number)
            else stringResource(id = R.string.email)

            Dialog(
                title = title, subTitle = subTitle,
                onConfirmClicked = {
                    showDialog = false
                    navController.navigateToVerificationCode()
                },
                onDismissClicked = {
                    showDialog = false
                },
                onDismissRequest = {
                    showDialog = false
                },
                textField = {
                    TextField(
                        hint = hint,
                        keyboardType = keyboardType,
                        onTextChange = {

                        }
                    )
                })

        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 25.dp, end = 25.dp, bottom = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            // app bar
            TopAppBar1(
                title = stringResource(R.string.forgot_password),
                subTitle = stringResource(id = R.string.this_data_will_be_displayed_in_your_account_profile_for_security),
                onBackClicked = { navController.navigateUp() }
            )

            SpacerHeight40()

            MethodList(
                modifier = Modifier.fillMaxSize(),
                methods = methods,
                onItemClicked = { data ->
                    method = data.type.name // set the method type
                }
            )


        }



        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp)
        ) {
            // button next
            SimpleButton(
                text = stringResource(id = R.string.next),
                onClick = {
                    showDialog = true
                }
            )
        }


    }


}


@Composable
fun MethodList(
    modifier: Modifier = Modifier,
    methods: List<ViaMethod>,
    startIndex: Int = 0,
    onItemClicked:(ViaMethod)-> Unit
) {
    var currentIndex by remember { mutableIntStateOf(startIndex) }

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        itemsIndexed(items = methods){ index, method ->
            MethodItem(
                title = method.title,
                subTitle = method.subTitle,
                icon = method.icon,
                isSelected = currentIndex == index,
                onClick = {
                    currentIndex = index // to change the state
                    onItemClicked(method)
                }
            )

        }

    }
}


@Composable
fun MethodItem(
    modifier: Modifier = Modifier,
    title: String,
    subTitle: String,
    isSelected: Boolean = false,
    selectedColor: Color = RichBlack4,
    icon: Int,
    onClick: () -> Unit
){
    val colorCard = if (isSelected) selectedColor else Color.White
    val titleColor = if (isSelected) Color.DarkGray else RichBlack3

    Card(
        modifier = modifier
            .fillMaxWidth()
            .light(BlueLight),
        onClick = { onClick() },
        colors = CardDefaults.cardColors(colorCard)
    ) {

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(22.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Image(
                modifier = modifier.size(40.dp),
                painter = painterResource(id = icon),
                contentDescription = title
            )

            SpacerWidth20()

            Column(
                modifier = Modifier.fillMaxWidth(),
            ) {

                TextLabelMedium(
                    text = title,
                    color = titleColor,
                )

                SpacerHeight10()

                TextLabelMedium(
                    text = subTitle,
                    color = RichBlack1,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16
                )
            }
        }

    }

}


@Preview
@Composable
fun MethodItemPreview(){
    MethodItem(
        title = "Via sms:",
        subTitle = "**** **** 3547",
        icon = R.drawable.ic_chat,
        isSelected = true
    ){}
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun ViaMethodPreview() {
    ViaMethod(rememberNavController())
}