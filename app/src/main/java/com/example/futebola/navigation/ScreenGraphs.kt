package com.example.futebola.navigation

sealed class ScreenGraphs(val route: String){
    object AppStartUp: ScreenGraphs(APP_START_UP_ROUTE)
    object Onboarding: ScreenGraphs(ONBOARDING_ROUTE)
    object Home: ScreenGraphs(HOME_ROUTE)

    companion object{
        private const val APP_START_UP_ROUTE = "app_start_up"
        private const val ONBOARDING_ROUTE = "onboarding"
        private const val HOME_ROUTE = "home"
    }
}
