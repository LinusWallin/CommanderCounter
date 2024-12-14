package com.example.commandercounter

import android.os.Bundle
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

        val gameViewModel: GameViewModel by viewModels()

        setContent {
            CommanderCounterTheme {
                Surface (color = MaterialTheme.colorScheme.background){
                    AppNavigation(gameViewModel)
                }
            }
        }
    }
}
