package com.example.commandercounter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.commandercounter.ui.theme.DarkGrey
import com.example.commandercounter.ui.theme.LightGreen
import com.example.commandercounter.viewmodels.GameViewModel

@Composable
fun Planechase(gameViewModel: GameViewModel) {

    val planes = gameViewModel.planes.collectAsState().value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkGrey),
        contentAlignment = Alignment.Center
    ) {
        if (planes.allPlanes.isEmpty()){
            Text("Loading...")
        } else {
            Column {
                Text(
                    text = planes.currentPlane.place,
                    color = LightGreen
                )
                Text(
                    text = planes.currentPlane.plane,
                    color = LightGreen
                )
                Text(
                    text = planes.currentPlane.effect,
                    color = LightGreen
                )
                Text(
                    text = planes.currentPlane.chaos,
                    color = LightGreen
                )
            }
        }
    }
}