package com.artemissoftware.amphitriteui2.animations.shorts

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun ButtonClickAnimation(
    animationDuration: Int = 100,
    scaleDown: Float = 0.9f
) {

    val interactionSource = MutableInteractionSource()

    val coroutineScope = rememberCoroutineScope()

    val scale = remember { Animatable(1f) }

    Box(
        modifier = Modifier
            .scale(scale = scale.value)
            .background(
                color = Color(0xFF35898F),
                shape = RoundedCornerShape(size = 12f)
            )
            .clickable(interactionSource = interactionSource, indication = null) {
                coroutineScope.launch {
                    scale.animateTo(
                        scaleDown,
                        animationSpec = tween(animationDuration),
                    )
                    scale.animateTo(
                        1f,
                        animationSpec = tween(animationDuration),
                    )
                }
            }
    ) {
        Text(
            text = "Button Animation",
            modifier = Modifier.padding(horizontal = 36.dp, vertical = 12.dp),
            fontSize = 26.sp,
            color = Color.White,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ButtonClickAnimationPreview() {
    ButtonClickAnimation()
}
