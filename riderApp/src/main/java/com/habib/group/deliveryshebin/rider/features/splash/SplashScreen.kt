package com.habib.group.deliveryshebin.rider.features.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.habib.group.deliveryshebin.rider.R
import com.habib.group.deliveryshebin.rider.onBoardingDestination
import com.habib.group.deliveryshebin.rider.utils.commonUI.VerticalSpace
import com.habib.group.deliveryshebin.rider.utils.theme.Primary
import com.habib.group.deliveryshebin.rider.utils.theme.White
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {

    val logoOffsetY = remember { Animatable(-300f) }
    val headerOffsetY = remember { Animatable(400f) }

    LaunchedEffect(Unit) {
        logoOffsetY.animateTo(
            targetValue = 0f,
            animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
        )

        headerOffsetY.animateTo(
            targetValue = 0f,
            animationSpec = tween(durationMillis = 1000, easing = LinearOutSlowInEasing)
        )

        delay(1000)
        navController.navigate(onBoardingDestination)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Primary)
    ) {
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(CircleShape)
                    .height(200.dp)
                    .offset(y = logoOffsetY.value.dp),
                contentDescription = "Logo",
                painter = painterResource(R.drawable.ic_logo_no_txt)
            )

            VerticalSpace(8.dp)

            Header(modifier = Modifier.offset(y = headerOffsetY.value.dp))
        }
    }
}

@Composable
fun Header(modifier: Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.delivery_shebin),
            color = White,
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold
        )

        VerticalSpace(8.dp)

        Text(
            text = stringResource(R.string.login_hint_1),
            color = White,
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            fontStyle = FontStyle.Normal
        )
    }
}