package com.artemissoftware.amphitriteui2.animations.glow

import androidx.compose.animation.Animatable
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.VectorConverter
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Glow() {
    val enable = remember { mutableStateOf(false) }

    val sizeFlag = remember { mutableStateOf(false) }

    val animateSize = remember { Animatable(initialValue = 30.dp, typeConverter = Dp.VectorConverter) }

    val animateColor = remember { Animatable(initialValue = Color.DarkGray) }
}
