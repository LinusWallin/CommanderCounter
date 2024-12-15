package com.example.commandercounter

import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowInsetsController
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.commandercounter.ui.navigation.AppNavigation
import com.example.commandercounter.ui.theme.CommanderCounterTheme
import com.example.commandercounter.viewmodels.GameViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        hideSystemBars()

        val gameViewModel: GameViewModel by viewModels()

        setContent {
            CommanderCounterTheme {
                Surface (color = MaterialTheme.colorScheme.background){
                    AppNavigation(gameViewModel)
                }
            }
        }
    }

    private fun hideSystemBars() {
        window.insetsController?.apply {
            systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
            hide(WindowInsets.Type.systemBars())
        }
    }

}
