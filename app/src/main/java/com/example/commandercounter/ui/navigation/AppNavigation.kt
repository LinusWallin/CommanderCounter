package com.example.commandercounter.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.commandercounter.ui.screens.StartMenuScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "start_menu") {
        composable("start_menu") {
            StartMenuScreen(navController)
        }
    }
}