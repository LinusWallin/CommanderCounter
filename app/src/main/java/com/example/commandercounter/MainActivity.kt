package com.example.commandercounter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.example.commandercounter.ui.navigation.AppNavigation
import com.example.commandercounter.ui.theme.CommanderCounterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CommanderCounterTheme {
                Surface (color = MaterialTheme.colorScheme.background){
                    AppNavigation()
                }
            }
        }
    }
}
