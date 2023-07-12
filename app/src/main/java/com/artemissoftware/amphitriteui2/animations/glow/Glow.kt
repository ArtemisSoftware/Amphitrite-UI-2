package com.artemissoftware.amphitriteui2.animations.glow

import android.R
import androidx.compose.animation.Animatable
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun Glow(
    modifier: Modifier = Modifier,
) {
    var enable by remember { mutableStateOf(false) }

    var sizeFlag by remember { mutableStateOf(false) }

    val animateSize = remember { Animatable(initialValue = 30.dp, typeConverter = Dp.VectorConverter) }

    val animateColor = remember { Animatable(initialValue = Color.DarkGray) }

    if (enable) {
        LaunchedEffect(key1 = sizeFlag) {
            animateColor.animateTo(
                generateRandomColor(),
                animationSpec = tween(1500),
            )

            sizeFlag = !sizeFlag
        }

        LaunchedEffect(key1 = sizeFlag) {
            animateSize.animateTo(
                targetValue = if (!sizeFlag) {
                    30.dp
                } else {
                    50.dp
                },
                animationSpec = tween(1500),
            )
        }
    } else {
        LaunchedEffect(key1 = sizeFlag) {
            animateColor.animateTo(
                Color.DarkGray,
                animationSpec = tween(5000),
            )

            sizeFlag = !sizeFlag
        }

        LaunchedEffect(key1 = sizeFlag) {
            animateSize.animateTo(
                targetValue = 0.dp,
                animationSpec = tween(1500),
            )
        }
    }

    Surface(
        modifier = modifier
            .fillMaxSize(),
        color = Color.Black,
    ) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Box(
                modifier = modifier
                    .clip(CircleShape)
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                animateColor.value,
                                Color.Transparent,
                            ),
                        ),
                    )
                    .padding(animateSize.value),
            ) {
                Box(
                    modifier = modifier
                        .size(160.dp)
                        .clip(CircleShape)
                        .background(Color.Black),
                    contentAlignment = Alignment.Center,
                ) {
                    Image(
                        painter = painterResource(
                            id = if (enable) {
                                com.artemissoftware.amphitriteui2.R.drawable.ic_stop
                            } else {
                                com.artemissoftware.amphitriteui2.R.drawable.ic_play
                            },
                        ),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        colorFilter = ColorFilter.tint(animateColor.value.copy(alpha = 0.8f)),
                        modifier = modifier
                            .size(100.dp)
                            .clickable {
                                enable = !enable
                            },

                    )
                }
            }
        }
    }
}

private fun generateRandomColor(): Color {
    val random = Random(System.currentTimeMillis())
    return Color(
        android.graphics.Color.argb(
            255,
            random.nextInt(256),
            random.nextInt(256),
            random.nextInt(256),
        ),
    )
}

@Preview
@Composable
private fun GlowPreview() {
    Glow(modifier = Modifier)
}
