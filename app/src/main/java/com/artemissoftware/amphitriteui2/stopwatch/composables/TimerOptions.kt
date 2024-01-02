package com.artemissoftware.amphitriteui2.stopwatch.composables

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Stop
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TimerOptions(
    isPlaying: Boolean,
    onStart: () -> Unit = {},
    onPause: () -> Unit = {},
    onStop: () -> Unit = {},
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.background(Color.LightGray, RoundedCornerShape(50)),
    ) {
        AnimatedContent(targetState = isPlaying, label = "") {
            if (it) {
                IconButton(onClick = onPause) {
                    Icon(imageVector = Icons.Filled.Pause, contentDescription = "")
                }
            } else {
                IconButton(onClick = onStart) {
                    Icon(imageVector = Icons.Filled.PlayArrow, contentDescription = "")
                }
            }
        }
        IconButton(onClick = onStop) {
            Icon(imageVector = Icons.Filled.Stop, contentDescription = "")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TimerOptionsPreview() {
    TimerOptions(
        isPlaying = true,
    )
}
