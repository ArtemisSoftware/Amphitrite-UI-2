package com.artemissoftware.amphitriteui2.animations.animatedcontent

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedContentScreen() {
    var isExpandend by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        Button(onClick = { isExpandend = !isExpandend }) {
            Text(text = if (isExpandend) "Collapse" else "Expanded")
        }
        Box(
            modifier = Modifier
                .animateContentSize(tween(500))
                .background(Color.Blue),
        ) {
            AnimatedContent(targetState = isExpandend, label = "") {
                if (it) {
                    Text(
                        text = "Expanded\nContent",
                        color = Color.White,
                        modifier = Modifier.padding(16.dp),
                    )
                } else {
                    Text(
                        text = "Collapsed",
                        color = Color.White,
                        modifier = Modifier.padding(16.dp),
                    )
                }
            }
        }
    }
}
