package com.habib.group.deliveryshebin.rider

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.habib.group.deliveryshebin.rider.features.auth.login.LoginScreen
import com.habib.group.deliveryshebin.rider.features.auth.register.RegisterScreen
import com.habib.group.deliveryshebin.rider.features.home.HomeScreen
import com.habib.group.deliveryshebin.rider.features.splash.GetStartedScreen
import com.habib.group.deliveryshebin.rider.features.splash.SplashScreen
import com.habib.group.deliveryshebin.rider.utils.theme.DeliveryShebinTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { DeliveryShebinTheme { MainApp() } }
    }
}

@Composable
private fun MainApp() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(startDestination) {
            SplashScreen {
                navController.navigate(getStartedDestination)
            }
        }

        composable(homeDestination) { HomeScreen() }

        composable(loginDestination) { LoginScreen() }

        composable(registerDestination) { RegisterScreen() }

        composable(getStartedDestination) { GetStartedScreen() }
    }
}

const val startDestination = "SPLASH_SCREEN"
const val homeDestination = "HOME_SCREEN_DESTINATION"
const val loginDestination = "LOGIN_SCREEN_DESTINATION"
const val registerDestination = "REGISTER_SCREEN_DESTINATION"
const val getStartedDestination = "GET_STARTED_SCREEN_DESTINATION"