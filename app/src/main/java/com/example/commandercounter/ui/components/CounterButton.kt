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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.commandercounter.data.models.Player
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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

        val scope = rememberCoroutineScope()
        var isPressed by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(btnColor, RoundedCornerShape(24.dp))
                .pointerInput(Unit) {
                    detectTapGestures(
                        onPress = {
                            isPressed = true
                            try {
                                awaitRelease()
                            } finally {
                                isPressed = false
                            }
                        },
                        onTap = { offset ->
                            if (offset.x < size.width / 2) {
                                player.decreasePlayerLife(1)
                            } else {
                                player.increasePlayerLife(1)
                            }
                        },
                        onLongPress = { offset ->
                            scope.launch {
                                while (isPressed) {
                                    if (offset.x < size.width / 2) {
                                        player.decreasePlayerLife(10)
                                    } else {
                                        player.increasePlayerLife(10)
                                    }
                                    delay(1000)
                                }

                            }
                        }
                    )
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