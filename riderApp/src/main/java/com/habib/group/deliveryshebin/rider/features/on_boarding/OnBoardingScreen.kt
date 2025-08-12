package com.habib.group.deliveryshebin.rider.features.on_boarding

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.habib.group.deliveryshebin.rider.loginDestination
import com.habib.group.deliveryshebin.rider.utils.isLandscape


@Composable
fun OnBoardingScreen(navController: NavHostController) {
    when {
        isLandscape() -> OnBoardingLandscape()
        else -> OnBoardingPortrait { navController.navigate(loginDestination) }
    }
}