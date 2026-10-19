package com.app.pokedexapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.app.pokedexapp.presentation.screens.detail.PokemonDetailScreen
import com.app.pokedexapp.presentation.screens.home.HomeScreen

sealed class Screen(
    val route: String,
) {
    // home es un objeto singleton que hereda de screen y define una ruta simple "Home"
    object Home : Screen("home")

    // Otro objeto que hereda de Screen
    // * Define una ruta con parámetro
    // * Incluye una funcion que construye la ruta real remplazando el parametro con un ID especifico
    object Detail : Screen("pokemon/{pokemonId}") {
        fun createRoute(pokemonId: String) = "pokemon/$pokemonId"
    }
}

@Suppress("ktlint:standard:function-naming")
@Composable
fun PokemonNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route,
        modifier = modifier,
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(
                onPokemonClick = { pokemonId ->
                    navController.navigate(Screen.Detail.createRoute(pokemonId))
                },
            )
        }
        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("pokemonId") { type = NavType.StringType }),
        ) { backStackEntry ->
            val pokemonId = backStackEntry.arguments?.getString("pokemonId") ?: "1"
            PokemonDetailScreen(
                pokemonId = pokemonId,
                onBackClick = { navController.popBackStack() },
            )
        }
    }
}
