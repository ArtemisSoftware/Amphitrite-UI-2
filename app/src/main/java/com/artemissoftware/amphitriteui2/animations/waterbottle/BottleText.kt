package com.artemissoftware.amphitriteui2.animations.waterbottle

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun BoxScope.bottleText(
    waterPercentage: Float,
    unit: String,
    bottleColor: Color = Color.White,
    waterWavesColor: Color = Color(0xff279EFF),
    description: String,
) {
    val text = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                color = if (waterPercentage > 0.5f) bottleColor else waterWavesColor,
                fontSize = 44.sp,
            ),
        ) {
            append(description)
        }
        withStyle(
            style = SpanStyle(
                color = if (waterPercentage > 0.5f) bottleColor else waterWavesColor,
                fontSize = 22.sp,
            ),
        ) {
            append(" ")
            append(unit)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .fillMaxHeight(),
        contentAlignment = Alignment.Center,
    ) {
        Text(text = text)
    }
}

@Preview
@Composable
private fun BottleTextPreview() {
    Box {
        bottleText(
            waterPercentage = 0.3F,
            bottleColor = Color.Red,
            description = "2500",
            unit = "ml",
        )
    }
}
