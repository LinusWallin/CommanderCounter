package com.example.commandercounter.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.commandercounter.data.models.Player

@Composable
fun CounterButton(
    btnColor: Color,
    textColor: Color,
    rotation: Float,
    player: Player,
    modifier: Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(4.dp)
            .rotate(rotation),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(btnColor, RoundedCornerShape(24.dp))
                .pointerInput(Unit) {
                    detectTapGestures { offset ->
                        if (offset.x < size.width / 2) {
                            player.decreasePlayerLife(1)
                        } else {
                            player.increasePlayerLife(1)
                        }
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = player.lifeTotal.toString(),
                color = textColor,
                fontSize = 40.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}