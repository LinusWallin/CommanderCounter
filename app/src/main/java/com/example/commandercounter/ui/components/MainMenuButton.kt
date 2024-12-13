package com.example.commandercounter.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.commandercounter.ui.theme.DarkGrey
import com.example.commandercounter.ui.theme.Green

@Composable
fun MainMenuButton(
    btnText: String,
    onClick: () -> Unit,
    isSelected: Boolean,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier.padding(8.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) Green else DarkGrey,
            contentColor = if (isSelected) DarkGrey else Green
        ),
        border = BorderStroke(
            width = 2.dp,
            color = Green
        )
    ) {
        Text(text = btnText)
    }
}