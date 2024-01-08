package com.artemissoftware.amphitriteui2.animations.series

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui2.ui.theme.blue400
import com.artemissoftware.amphitriteui2.ui.theme.deepGold
import com.artemissoftware.amphitriteui2.ui.theme.redOrange

private const val ANIMATION_DURATION = 5000

@Composable
fun AnimationSeriesScreen() {
    var isVisible by remember { mutableStateOf(true) }
    var isColorChanged by remember { mutableStateOf(false) }
    var isRotated by remember { mutableStateOf(false) }

    // Define the rotation animation values
    val rotationAngle by animateFloatAsState(
        targetValue = if (isRotated) 360f else 0f,
        animationSpec = tween(durationMillis = ANIMATION_DURATION),
        label = "",
    )

    // Define the color animation values
    val targetColor by animateColorAsState(
        targetValue = if (isColorChanged) blue400 else deepGold,
        animationSpec = tween(durationMillis = ANIMATION_DURATION),
        label = "",
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        AnimatedVisibility(
            visible = isVisible,
            enter = scaleIn(tween(ANIMATION_DURATION)),
            exit = scaleOut(animationSpec = tween(ANIMATION_DURATION)),
        ) {
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .graphicsLayer(rotationZ = rotationAngle)
                    .background(targetColor),
            ) {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .size(20.dp)
                        .background(redOrange),
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                isVisible = !isVisible
                isColorChanged = !isColorChanged
                isRotated = !isRotated
            },
        ) {
            Text(if (isVisible) "reverse animation" else "animate")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AnimationSeriesScreenPreview() {
    AnimationSeriesScreen()
}
