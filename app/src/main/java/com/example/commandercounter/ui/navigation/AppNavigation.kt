package com.example.commandercounter.ui.navigation

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.commandercounter.ui.screens.GameScreen
import com.example.commandercounter.ui.screens.StartMenuScreen
import com.example.commandercounter.viewmodels.GameViewModel

@Composable
fun AppNavigation(gameViewModel: GameViewModel) {
    val navController = rememberNavController()
    val activity = LocalContext.current as Activity

    NavHost(navController = navController, startDestination = "start_menu") {
        composable("start_menu") {
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
            StartMenuScreen(navController, gameViewModel)
        }
        composable("game_screen") {
            GameScreen(navController, gameViewModel)
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
    }
}