package com.example.commandercounter.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.commandercounter.ui.components.MainMenuButtonRow
import com.example.commandercounter.ui.components.PlayButton
import com.example.commandercounter.ui.theme.LightGreen
import com.example.commandercounter.viewmodels.GameViewModel

@Composable
fun StartMenuScreen(navController: NavController, gameViewModel: GameViewModel) {

    val gameModel = gameViewModel.game.collectAsState().value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text(
                text = "NUMBER OF PLAYERS",
                color = LightGreen
            )

            MainMenuButtonRow(
                start = 2,
                end = 4,
                stepSize = 1,
                isSelected = { numPlayers -> gameModel.playerCount == numPlayers },
                onClick = { numPlayers -> gameViewModel.setPlayerCount(numPlayers) }
            )

            Text(
                text = "STARTING LIFE",
                color = LightGreen,
                modifier = Modifier.padding(top = 25.dp)
            )

            MainMenuButtonRow(
                start = 10,
                end = 40,
                stepSize = 10,
                isSelected = { startLife -> gameModel.playetStartLife == startLife },
                onClick = { startLife -> gameViewModel.setPlayerStartLife(startLife) }
            )

            PlayButton(
                navController = navController,
                modifier = Modifier.padding(top = 20.dp)
            )

        }
    }
}