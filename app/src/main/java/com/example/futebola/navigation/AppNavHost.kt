package com.example.futebola.navigation

import android.annotation.SuppressLint
import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.common.datastore.getSharedValue
import com.example.common.datastore.saveBoolean
import com.example.futebola.login.LoginOnboardingComponent
import com.example.futebola.login.LoginScreen
import com.example.onboarding.OnboardingPagerComponent
import com.example.onboarding.OnboardingSteps
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@SuppressLint("ComposableDestinationInComposeScope")
@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String
) {

    val context = LocalContext.current
    val coroutine = rememberCoroutineScope()

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        appStartUpGraph(
            navController = navController,
            context = context,
            coroutineScope = coroutine
        )
        loginGraph(navController = navController)
        homeNavGraph(navController = navController)
    }
}

fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController,
) {
    navigation(route = "home_graph", startDestination = ScreenGraphs.Home.route) {
        composable(ScreenGraphs.Home.route) {

        }
        composable(HomeScreens.League.route) {

        }

        composable(HomeScreens.Live.route) {

        }

        composable(HomeScreens.Another.route) {

        }
    }
}

fun NavGraphBuilder.loginGraph(
    navController: NavHostController
){
    navigation(route = "login_graph", startDestination = "login_onboarding"){
        composable(route = "login"){
            LoginScreen {
                navController.navigate("home_graph"){
//                    popUpTo("login"){
//                        inclusive = true
//                    }
                }
            }
        }

        composable(route = "login_onboarding"){
            LoginOnboardingComponent {
                navController.navigate("login")
            }
        }
    }
}

fun NavGraphBuilder.appStartUpGraph(
    navController: NavHostController,
    context: Context,
    coroutineScope: CoroutineScope
) {
    navigation(route = "app_start_graph", startDestination = ScreenGraphs.Onboarding.route) {
        composable(ScreenGraphs.Onboarding.route) {
            OnboardingPagerComponent(
                onboardingSteps = OnboardingSteps.values().toList(),
                onOnboardingFinish = {
                    navController.popBackStack()
                    navController.navigate(ScreenGraphs.Home.route)
                    coroutineScope.launch {
                        context.saveBoolean("ONBOARDING", true)
                    }
                })

        }

        composable("app_start") {
            val onboarding =
                context.getSharedValue("ONBOARDING").collectAsState(initial = false).value
            when (onboarding) {
                true -> navController.navigate(ScreenGraphs.Home.route)
                false -> navController.navigate(ScreenGraphs.Onboarding.route)
            }
        }
    }
}