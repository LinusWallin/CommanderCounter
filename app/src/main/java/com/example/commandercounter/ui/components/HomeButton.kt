package com.example.commandercounter.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.commandercounter.ui.theme.Green

@Composable
fun HomeButton(navController: NavController) {

    IconButton(
        onClick = {navController.navigate("start_menu")}
    ) {
        Icon(
            imageVector = Icons.Default.Home,
            contentDescription = "Home",
            tint = Green,
            modifier = Modifier
                .size(40.dp)
        )
    }

}