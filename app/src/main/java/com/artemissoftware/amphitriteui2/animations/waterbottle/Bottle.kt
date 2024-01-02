package com.artemissoftware.amphitriteui2.animations.waterbottle

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.clipPath

fun DrawScope.bottle(
    width: Float,
    height: Float,
    waterPercentage: Float,
    bottleColor: Color = Color.White,
    waterWavesColor: Color = Color(0xff279EFF),
) {
    clipPath(
        path = bodyPath(width = width, height = height),
    ) {
        // Draw the color of the bottle
        drawRect(
            color = bottleColor,
            size = size,
            topLeft = Offset(0f, 0f),
        )

        waterWave(
            waterPercentage = waterPercentage,
            waterWavesColor = waterWavesColor,
        )
    }
}

private fun bodyPath(width: Float, height: Float): Path {
    return Path()
        .apply {
            moveTo(width * 0.3f, height * 0.1f)
            lineTo(width * 0.3f, height * 0.2f)
            quadraticBezierTo(
                x1 = 0f,
                y1 = height * 0.3f,
                x2 = 0f,
                y2 = height * 0.4f,
            )
            lineTo(0f, height * 0.95f)
            quadraticBezierTo(
                x1 = 0f,
                y1 = height,
                x2 = width * 0.05f,
                y2 = height,
            )

            lineTo(width * 0.95f, height)
            quadraticBezierTo(
                x1 = width,
                y1 = height,
                x2 = width,
                y2 = height * 0.95f,
            )
            lineTo(width, height * 0.4f)
            quadraticBezierTo(
                x1 = width,
                y1 = height * 0.3f,
                x2 = width * 0.7f,
                y2 = height * 0.2f,
            )
            lineTo(width * 0.7f, height * 0.2f)
            lineTo(width * 0.7f, height * 0.1f)

            close()
        }
}

private fun DrawScope.waterWavePath(waterPercentage: Float): Path {
    val waterWavesYPosition = (1 - waterPercentage) * size.height

    return Path().apply {
        moveTo(
            x = 0f,
            y = waterWavesYPosition,
        )
        lineTo(
            x = size.width,
            y = waterWavesYPosition,
        )
        lineTo(
            x = size.width,
            y = size.height,
        )
        lineTo(
            x = 0f,
            y = size.height,
        )
        close()
    }
}

private fun DrawScope.waterWave(waterPercentage: Float, waterWavesColor: Color) {
    drawPath(
        path = waterWavePath(waterPercentage = waterPercentage),
        color = waterWavesColor,
    )
}

