package com.example.foodninja.screens.verificationCode

import android.os.CountDownTimer
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodninja.R
import com.example.foodninja.SharedViewModel
import com.example.foodninja.composable.ExpandToFit
import com.example.foodninja.composable.SimpleButton
import com.example.foodninja.composable.SpacerHeight30
import com.example.foodninja.composable.SpacerWidth10
import com.example.foodninja.composable.TopAppBar1
import com.example.foodninja.data.User
import com.example.foodninja.screens.resetPassword.navigateToResetPassword
import com.example.foodninja.ui.theme.BlueLight
import com.example.foodninja.ui.theme.RichBlack1
import com.example.foodninja.utils.OtpConfiguration
import com.example.foodninja.utils.RangeType
import com.example.foodninja.utils.SharePrefApp
import com.example.foodninja.utils.convertToStar
import com.example.foodninja.utils.light
import com.example.foodninja.utils.longToDate


@Composable
fun VerificationCode(
    navController: NavController,
    shareViewModel: SharedViewModel = hiltViewModel()
) {
    val user = shareViewModel.user.collectAsState().value

    VerificationCodeContent(
        user = user,
        onNextClicked = {
            navController.navigateToResetPassword()
        }
    )
}

@Composable
fun VerificationCodeContent(
    user: User,
    onNextClicked:()-> Unit
){
    var otpCode by remember { mutableStateOf("1923") }
    var countryCode by remember { mutableIntStateOf(218) }
    var remainingTime by remember { mutableStateOf("01:50") }

    val phone = convertToStar(user.phone,RangeType.LAST)

    val timer = object: CountDownTimer(
        OtpConfiguration.EXPIRED_OTP_TIME,
        1000L
    ){
        override fun onTick(millisUntilFinished: Long) {
            val time = longToDate(millisUntilFinished)
            remainingTime = time
        }

        override fun onFinish() {
            remainingTime = ""
        }
    }

    LaunchedEffect(key1 = true){
        timer.start()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 25.dp, end = 25.dp, bottom = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        // app bar
        TopAppBar1(
            title = stringResource(R.string.enter_4_digit_verification_code),
            subTitle = stringResource(R.string.code_send_title,countryCode, phone,remainingTime)
        )

        SpacerHeight30()

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .light(BlueLight),
            colors = CardDefaults.cardColors(Color.White),
            shape = RoundedCornerShape(16.dp),
        ) {

            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {


                SpacerWidth10()

                Text(
                    text = otpCode,
                    color = RichBlack1,
                    fontWeight = FontWeight.Bold,
                    fontSize = 35.sp,
                    letterSpacing = 35.sp
                )
            }

        }

        ExpandToFit()

        // button next
        SimpleButton(
            text = stringResource(id = R.string.next),
            onClick = { onNextClicked() }
        )
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun VerificationCodePreview() {
    VerificationCodeContent(
        user = User(),
        onNextClicked = {}
    )
}