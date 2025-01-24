package com.example.commandercounter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.commandercounter.ui.theme.LightGrey
import com.example.commandercounter.viewmodels.GameViewModel

@Composable
fun GameMenu(navController: NavController, gameViewModel: GameViewModel) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {},
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(width = 220.dp, height = 60.dp)
                .background(LightGrey, RoundedCornerShape(8.dp))
                .pointerInput(Unit) {},
            contentAlignment = Alignment.Center
        ) {
            Row {
                ResetButton(gameViewModel)
                CloseMenuButton(
                    onClickAction = { gameViewModel.toggleMenu() }
                )
                PlaneMenuButton(gameViewModel)
                HomeButton(navController, gameViewModel)
            }
        }

    }
}