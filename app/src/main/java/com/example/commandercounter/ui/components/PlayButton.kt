package com.example.commandercounter.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.commandercounter.ui.theme.DarkGrey
import com.example.commandercounter.ui.theme.Green

@Composable
fun PlayButton(
    navController: NavController,
    modifier: Modifier
) {
    Button(
        onClick = { navController.navigate("game_screen") },
        modifier = modifier
            .padding(8.dp)
            .width(90.dp)
            .height(45.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Green,
            contentColor = DarkGrey
        )
    ) {
        Text(
            text = "PLAY"
        )
    }
}