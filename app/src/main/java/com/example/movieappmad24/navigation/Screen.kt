package com.example.movieappmad24.navigation

sealed class Screen(val route: String) {
    object HomeScreen: Screen(route = "homeScreen")
    object DetailScreen: Screen(route = "detailscreen/{movieId}")
    object WatchListScreen: Screen(route = "watchlist")

}