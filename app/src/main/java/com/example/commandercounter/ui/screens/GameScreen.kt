package com.example.commandercounter.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.commandercounter.data.models.Player
import com.example.commandercounter.ui.components.CounterButton
import com.example.commandercounter.ui.components.GameMenu
import com.example.commandercounter.ui.components.OpenMenuButton
import com.example.commandercounter.ui.theme.DarkGrey
import com.example.commandercounter.ui.theme.Green
import com.example.commandercounter.viewmodels.GameViewModel

@Composable
fun GameScreen(navController: NavController, gameViewModel: GameViewModel) {

    val gameModel = gameViewModel.game.collectAsState().value
    val gameMenu = gameViewModel.menu.collectAsState().value

    for (playerName in 1..gameModel.playerCount) {
        gameViewModel.appendPlayer(Player(
            playerName,
            gameModel.playetStartLife,
        ))
    }

    var playerIdx = 0

    if (gameModel.playerList.isNotEmpty()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(DarkGrey)
        ) {
            Row(
                modifier = Modifier
                    .weight(1f)
            ) {
                CounterButton(
                    btnColor = Green,
                    textColor = DarkGrey,
                    rotation = 180f,
                    player = gameModel.playerList[playerIdx],
                    modifier = Modifier.weight(1f)
                )

                if (gameModel.playerCount > 2) {
                    playerIdx += 1
                    CounterButton(
                        btnColor = Green,
                        textColor = DarkGrey,
                        rotation = 180f,
                        player = gameModel.playerList[playerIdx],
                        modifier = Modifier.weight(1f)
                    )
                }
            }

            Row(
                modifier = Modifier
                    .weight(1f)
            ) {
                playerIdx += 1
                CounterButton(
                    btnColor = Green,
                    textColor = DarkGrey,
                    rotation = 0f,
                    player = gameModel.playerList[playerIdx],
                    modifier = Modifier.weight(1f)
                )

                if (gameModel.playerCount > 3) {
                    playerIdx += 1
                    CounterButton(
                        btnColor = Green,
                        textColor = DarkGrey,
                        rotation = 0f,
                        player = gameModel.playerList[playerIdx],
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }

        if (!gameMenu) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                OpenMenuButton(gameViewModel)
            }
        }else {
            GameMenu(navController, gameViewModel)
        }
    }

}

