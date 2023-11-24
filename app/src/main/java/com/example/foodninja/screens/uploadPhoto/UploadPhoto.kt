@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.foodninja.screens.uploadPhoto

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.foodninja.R
import com.example.foodninja.SharedViewModel
import com.example.foodninja.composable.*
import com.example.foodninja.screens.setLocation.navigateToSetLocation
import com.example.foodninja.ui.theme.RichBlack4
import com.example.foodninja.utils.Organized

@Composable
fun UploadPhoto(
    navController: NavController,
    sharedViewModel: SharedViewModel = hiltViewModel()
) {
    val context = LocalContext.current

    val user = sharedViewModel.user.collectAsState().value

    UploadPhotoContent (
        onBackClicked = {
            navController.navigateUp()
        },
        onNextClicked = { image ->
            val updated = user.copy(imgProfile = image)
            sharedViewModel.updateUser(updated)
            navController.navigateToSetLocation()
        }
    )
}


@Composable
fun UploadPhotoContent(
    onBackClicked:()-> Unit = {},
    onNextClicked:(Int) -> Unit = {}
) {
    var image by remember { mutableIntStateOf(0) }
    val isSelectedImage = image != 0 // show or hide image preview

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 25.dp, end = 25.dp, bottom = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        // app bar
        TopAppBar1(
            title = stringResource(R.string.upload_your_photo_profile),
            subTitle = stringResource(id = R.string.this_data_will_be_displayed_in_your_account_profile_for_security),
            onBackClicked = { onBackClicked()}
        )

        SpacerHeight40()

        if (isSelectedImage){
            Box() {
                SquareImage(
                    imageRes = image,
                    size = 260
                )

                // button close Image
                Card(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 12.dp, end = 8.dp),
                    onClick = {
                        image = 0 // clear image selected
                    },
                    colors = CardDefaults.cardColors(Color.Transparent),
                    shape = CircleShape
                ) {
                    Box(
                        modifier = Modifier
                            .alpha(0.8f)
                            .background(RichBlack4)
                    ) {
                        Icon(
                            modifier = Modifier
                                .padding(5.dp)
                                .size(15.dp),
                            painter = painterResource(id = R.drawable.ic_close),
                            contentDescription = "icon cancel",
                            tint = Color.White
                        )
                    }
                }
            }

        }else{
            // button select from gallery
            IconButtonText(
                title = stringResource(id = R.string.from_gallery),
                icon = R.drawable.ic_gallery,
                contentOrganized = Organized.Vertical,
                onClick = {
                    image = R.drawable.ic_photo_test
                }
            )

            SpacerHeight15()

            // button take photo
            IconButtonText(
                title = stringResource(id = R.string.take_photo),
                icon = R.drawable.ic_camera,
                contentOrganized = Organized.Vertical,
                onClick = {
                    image = R.drawable.ic_photo_test
                }
            )


        }


        ExpandToFit()

        // button next
        SimpleButton(
            text = stringResource(id = R.string.next),
            onClick = { onNextClicked(image) }
        )
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UploadPhotoPreview() {
    UploadPhotoContent()
}