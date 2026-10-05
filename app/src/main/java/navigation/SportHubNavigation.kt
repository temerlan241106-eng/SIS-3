package com.example.sporthub.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.sporthub.data.AthleteRepository
import com.example.sporthub.ui.screens.AthleteDetailScreen
import com.example.sporthub.ui.screens.AthletesScreen
import com.example.sporthub.ui.screens.FavoritesScreen

@Composable
fun SportHubNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "athletes"
    ) {

        composable("athletes") {
            AthletesScreen(
                onAthleteClick = { athleteId ->
                    navController.navigate("details/$athleteId")
                },
                onFavoritesClick = {
                    navController.navigate("favorites")
                }
            )
        }

        composable(
            route = "details/{athleteId}",
            arguments = listOf(
                navArgument("athleteId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val athleteId =
                backStackEntry.arguments?.getInt("athleteId")

            val athlete = AthleteRepository.athletes
                .find { it.id == athleteId }

            if (athlete != null) {
                AthleteDetailScreen(
                    athlete = athlete,
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }
        }

        composable("favorites") {
            FavoritesScreen()
        }
    }
}