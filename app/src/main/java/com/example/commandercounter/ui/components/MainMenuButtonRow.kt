package com.example.commandercounter.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MainMenuButtonRow(
    start: Int,
    end: Int,
    stepSize: Int,
    isSelected: (Int) -> Boolean,
    onClick: (Int) -> Unit
) {
    Row {
        for (value in start..end step stepSize) {
            MainMenuButton(
                btnText = value.toString(),
                onClick = {onClick(value)},
                isSelected = isSelected(value),
                modifier = Modifier.padding(2.dp)
            )
        }
    }
}