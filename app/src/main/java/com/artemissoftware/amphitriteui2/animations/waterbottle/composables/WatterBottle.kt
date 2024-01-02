package com.artemissoftware.amphitriteui2.animations.waterbottle.composables

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun WatterBottle(
    unit: String,
    totalWaterAmount: Int,
    usedWaterAmount: Int,
    modifier: Modifier = Modifier,
    waterWavesColor: Color = Color(0xff279EFF),
    bottleColor: Color = Color.White,
    capColor: Color = Color(0xFF0065B9),
) {
    val waterPercentage = animateFloatAsState(
        targetValue = (usedWaterAmount.toFloat() / totalWaterAmount.toFloat()),
        label = "Water Waves animation",
        animationSpec = tween(durationMillis = 1000),
    ).value

    val usedWaterAmountAnimation = animateIntAsState(
        targetValue = usedWaterAmount,
        label = "Used water amount animation",
        animationSpec = tween(durationMillis = 1000),
    ).value

    Box(
        modifier = modifier,
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height

            bottle(
                width = width,
                height = height,
                waterPercentage = waterPercentage,
                bottleColor = bottleColor,
                waterWavesColor = waterWavesColor,
            )

            val capWidth = size.width * 0.55f
            val capHeight = size.height * 0.13f

            bottleCap(
                capColor = capColor,
                capWidth = capWidth,
                capHeight = capHeight,
            )
        }

        bottleText(
            unit = unit,
            waterPercentage = waterPercentage,
            description = usedWaterAmountAnimation.toString(),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun WaterBottlePreview() {
    WatterBottle(
        totalWaterAmount = 2500,
        unit = "ml",
        usedWaterAmount = 120,
    )
}
