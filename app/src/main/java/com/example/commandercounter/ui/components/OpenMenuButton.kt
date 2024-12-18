package com.example.commandercounter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import com.example.commandercounter.ui.theme.Green
import com.example.commandercounter.ui.theme.LightGrey
import com.example.commandercounter.viewmodels.GameViewModel

@Composable
fun OpenMenuButton(gameViewModel: GameViewModel) {

    Box(
        modifier = Modifier
            .size(60.dp)
            .background(LightGrey, RoundedCornerShape(8.dp))
            .pointerInput(Unit){},
        contentAlignment = Alignment.Center
    ) {
        IconButton(
            onClick = {gameViewModel.toggleMenu()}
        ) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = "Menu",
                tint = Green,
                modifier = Modifier
                    .size(40.dp)
            )
        }
    }


}