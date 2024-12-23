package com.example.commandercounter.ui.components

import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.commandercounter.R
import com.example.commandercounter.ui.theme.Green
import com.example.commandercounter.viewmodels.GameViewModel

@Composable
fun PlaneMenuButton(gameViewModel: GameViewModel) {
    IconButton(
        onClick = {gameViewModel.togglePlaneChase()}
    ) {
        Icon(
            painter = painterResource(id = R.drawable.planechase),
            contentDescription = "Planechase",
            tint = Green,
            modifier = Modifier
        )
    }
}