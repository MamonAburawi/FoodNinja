@file:OptIn(ExperimentalFoundationApi::class)

package com.example.foodninja.screens.onBoarding

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodninja.R
import com.example.foodninja.composable.DrawBackgroundPattern
import com.example.foodninja.composable.AppBrandLogo
import com.example.foodninja.data.OnBoarding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import com.example.foodninja.composable.*
import com.example.foodninja.screens.signIn.navigateToSignIn
import com.example.foodninja.utils.*

@Composable
private fun getOnBoardScreens(): List<OnBoarding> {
    return listOf(
        OnBoarding(
            ic = R.drawable.ic_onboarding1,
            title = stringResource(R.string.title_onBoard1) ,
            subTitle = stringResource(id = R.string.sub_title_onboard1)
        ),
        OnBoarding(
            ic = R.drawable.ic_onboarding2,
            title = stringResource(R.string.title_onBoard2) ,
            subTitle = stringResource(id = R.string.sub_title_onboard2)
        )
    )
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun OnBoarding(navController: NavController) {
    var inPager by remember{ mutableStateOf(false) }
    val context = LocalContext.current
    val sharePref = SharePrefApp(context)



    if (inPager){
        Pager(
            list = getOnBoardScreens(),
            onLastNextClicked =  {
                navController.apply {
                    sharePref.trackFirstOpen()
                    popBackStack()
                    navigateToSignIn()
                }
            }
        )
    }else {
        Splash()
    }

    LaunchedEffect(key1 = inPager) {
        delay(3000)
        val isOpenBefore = sharePref.isOpenBefore()
        if (isOpenBefore){
            navController.apply {
                popBackStack()
                navigateToSignIn()
            }
        }else {
            inPager = true
        }


    }

}


@Composable
fun Splash(

){
    Box(modifier = Modifier.fillMaxSize()) {
        DrawBackgroundPattern()
        AppBrandLogo(modifier = Modifier.align(Alignment.Center))
    }
}


@Composable
fun Pager(
    list: List<OnBoarding>,
    initialPosition: Int = 0,
    onLastNextClicked:()->Unit
){
    var currentPosition by remember{ mutableIntStateOf(initialPosition) }
    val pagerState = rememberPagerState(initialPage = currentPosition) {2}
    val scope = rememberCoroutineScope()

    HorizontalPager(state = pagerState) {
        when(pagerState.currentPage){
            0 ->{
                PagerContent(data = list[it]) {
                    scope.launch {
                        val nextPage = it + 1
                        pagerState.animateScrollToPage(nextPage)
                        currentPosition = nextPage
                    }
                }
            }
            1 -> {
                PagerContent(data = list[it]) {
                    scope.launch {
                        onLastNextClicked()
                    }
                }
            }
        }

    }
}


@Composable
fun PagerContent(
    data: OnBoarding,
    onNextClicked:()-> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Image(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth()
                .height(330.dp),
            painter = painterResource(id = data.ic),
            contentDescription = data.title,
        )

        ExpandToFit()

        Column(modifier = Modifier.width(240.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            TextLabelLarge(
                text = data.title,
                fontSize = 24,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextLabelMedium(
                text = data.subTitle,
                fontSize = 12,
                textAlign = TextAlign.Center
            )

        }

        ExpandToFit()


        SimpleButton(
            modifier = Modifier,
            text = stringResource(id = R.string.next),
            onClick = { onNextClicked() }
        )

        SpacerHeight40()


    }
}



@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SplashScreenPreview() {
    Splash()
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun OnBoardingPreview() {
    OnBoarding(rememberNavController())
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun PagerPreview() {
    Pager(
        list = getOnBoardScreens(),
        onLastNextClicked = {}
    )
}
