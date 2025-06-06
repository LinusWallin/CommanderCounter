package com.example.commandercounter.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.commandercounter.ui.theme.Green

@Composable
fun CloseMenuButton(onClickAction: () -> Unit) {

    IconButton(
        onClick = onClickAction
    ) {
        Icon(
            imageVector = Icons.Default.Close,
            contentDescription = "Close",
            tint = Green,
            modifier = Modifier
                .size(40.dp)
        )
    }

}