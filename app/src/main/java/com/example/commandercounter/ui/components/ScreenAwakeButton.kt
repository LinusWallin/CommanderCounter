package com.example.commandercounter.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import com.example.commandercounter.ui.theme.Green
import com.example.commandercounter.ui.theme.LightGreen
import com.example.commandercounter.viewmodels.GameViewModel

@Composable
fun ScreenAwakeButton(gameViewModel: GameViewModel) {

    val screenAwake = gameViewModel.screenAwake.collectAsState().value

    Row(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = screenAwake,
            onCheckedChange = {
                gameViewModel.toggleScreenAwake()
            },
            colors = CheckboxDefaults.colors(
                checkedColor = Green,
                uncheckedColor = LightGreen,
                checkmarkColor = DarkGray
            )
        )

        Text("Keep Screen Awake")
    }
}