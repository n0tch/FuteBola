package com.example.futebola.navigation

sealed class HomeScreens(val route: String){
    object League: HomeScreens(LEAGUE_ROUTE)
    object Live: HomeScreens(LIVE_ROUTE)
    object Another: HomeScreens(ANOTHER_ROUTE)

    companion object {
        private const val LEAGUE_ROUTE = "league"
        private const val LIVE_ROUTE = "live"
        private const val ANOTHER_ROUTE = "another"

        fun homeScreensItems() = listOf(
            League,
            Live,
            Another
        )
    }
}
