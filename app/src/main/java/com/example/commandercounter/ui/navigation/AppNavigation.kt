package com.example.commandercounter.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.commandercounter.ui.screens.GameScreen
import com.example.commandercounter.ui.screens.StartMenuScreen
import com.example.commandercounter.viewmodels.GameViewModel

@Composable
fun AppNavigation(gameViewModel: GameViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "start_menu") {
        composable("start_menu") {
            StartMenuScreen(navController, gameViewModel)
        }
        composable("game_screen") {
            GameScreen(navController, gameViewModel)
        }
    }
}