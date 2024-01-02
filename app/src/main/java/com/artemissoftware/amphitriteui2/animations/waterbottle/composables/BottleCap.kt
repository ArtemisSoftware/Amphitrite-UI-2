package com.artemissoftware.amphitriteui2.animations.waterbottle.composables

import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope

fun DrawScope.bottleCap(
    capColor: Color,
    capWidth: Float,
    capHeight: Float,
) {
    drawRoundRect(
        color = capColor,
        size = Size(capWidth, capHeight),
        topLeft = Offset(size.width / 2 - capWidth / 2f, 0f),
        cornerRadius = CornerRadius(45f, 45f),
    )
}
