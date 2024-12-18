package com.example.commandercounter.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.commandercounter.ui.theme.Green
import com.example.commandercounter.viewmodels.GameViewModel

@Composable
fun ResetButton(gameViewModel: GameViewModel) {

    val gameModel = gameViewModel.game.collectAsState().value

    IconButton(
        onClick = {
            for (player in gameModel.playerList) {
                player.lifeTotal = gameModel.playetStartLife
            }
            gameViewModel.toggleMenu()
        }
    ) {
        Icon(
            imageVector = Icons.Default.Refresh,
            contentDescription = "Reset",
            tint = Green,
            modifier = Modifier
                .size(40.dp)
        )
    }

}