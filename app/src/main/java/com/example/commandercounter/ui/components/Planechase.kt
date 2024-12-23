package com.example.commandercounter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.commandercounter.ui.theme.DarkGrey
import com.example.commandercounter.ui.theme.LightGreen
import com.example.commandercounter.viewmodels.GameViewModel

@Composable
fun Planechase(gameViewModel: GameViewModel) {

    val planes = gameViewModel.planes.collectAsState().value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkGrey),
        contentAlignment = Alignment.Center
    ) {
        if (planes.allPlanes.isEmpty()){
            Text("Loading...")
        } else {
            var planeName = planes.currentPlane.plane
            if (planeName != "Phenomenon") {
                planeName = "Plane - " + planeName
            }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = planes.currentPlane.place,
                        color = LightGreen,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                    )
                    Text(
                        text = planeName,
                        color = LightGreen,
                        fontSize = 24.sp,
                        fontStyle = FontStyle.Italic
                    )
                }

                Column {
                    Text(
                        text = planes.currentPlane.effect,
                        color = LightGreen,
                        fontSize = 16.sp
                    )
                    if (planes.currentPlane.chaos != "None") {
                        Text(
                            text = "Whenever chaos ensues, " + planes.currentPlane.chaos,
                            color = LightGreen,
                            fontSize = 16.sp
                        )
                    }
                }
            }

            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                NextPlaneButton(gameViewModel)
            }

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp),
                contentAlignment = Alignment.TopEnd
            ) {
                CloseMenuButton(
                    onClickAction = { gameViewModel.togglePlaneChase() }
                )
            }
        }
    }
}