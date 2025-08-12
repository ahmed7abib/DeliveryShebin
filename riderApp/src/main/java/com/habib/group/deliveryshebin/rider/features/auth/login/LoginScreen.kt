package com.habib.group.deliveryshebin.rider.features.auth.login


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.habib.group.deliveryshebin.rider.homeDestination
import com.habib.group.deliveryshebin.rider.registerDestination
import com.habib.group.deliveryshebin.rider.utils.isLandscape


@Composable
fun LoginScreen(navController: NavHostController) {
    when {
        isLandscape() -> LoginLandscape(
            onSignInClick = { onSignInClicked(navController) },
            onIgnoreClicked = { onIgnoreClicked(navController) }
        )

        else -> LoginPortrait(
            onSignInClick = { onSignInClicked(navController) },
            onIgnoreClicked = { onIgnoreClicked(navController) }
        )
    }
}

private fun onSignInClicked(navController: NavHostController) {
    navController.navigate(registerDestination)
}

private fun onIgnoreClicked(navController: NavHostController) {
    navController.navigate(homeDestination)
}