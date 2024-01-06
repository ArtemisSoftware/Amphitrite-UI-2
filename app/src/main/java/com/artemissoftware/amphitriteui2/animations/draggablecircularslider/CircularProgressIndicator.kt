package com.artemissoftware.amphitriteui2.animations.draggablecircularslider

import android.graphics.Paint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.artemissoftware.amphitriteui2.ui.theme.White
import com.artemissoftware.amphitriteui2.ui.theme.gray
import com.artemissoftware.amphitriteui2.ui.theme.orange
import java.lang.Math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun CircularProgressIndicator(
    modifier: Modifier = Modifier,
    initialValue: Int,
    primaryColor: Color,
    secondaryColor: Color,
    circleRadius: Float,
    minValue: Int = 0,
    maxValue: Int = 100,
    onPositionChange: (Int) -> Unit,
) {
    var circleCenter by remember { mutableStateOf(Offset.Zero) }
    var circleDiameter by remember { mutableFloatStateOf(circleRadius * 2F) }

    var positionValue by remember {
        mutableIntStateOf(initialValue)
    }

    Box(modifier = modifier) {
        Canvas(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            val width = size.width
            val height = size.height
            val circleThickness = width / 25f
            circleCenter = Offset(x = width / 2f, y = height / 2f)

            drawCircle(
                brush = Brush.radialGradient(
                    listOf(
                        primaryColor.copy(0.45f),
                        secondaryColor.copy(0.15f),
                    ),
                ),
                radius = circleRadius,
                center = circleCenter,
            )

            circularProgressBase(
                thickness = circleThickness,
                color = secondaryColor,
                radius = circleRadius,
                center = circleCenter,
            )

            circularProgress(
                color = primaryColor,
                thickness = circleThickness,
                progressPercentage = (360f / maxValue) * positionValue.toFloat(),
                size = Size(width = circleDiameter, height = circleDiameter),
                topLeft = Offset(
                    (width - circleDiameter) / 2f,
                    (height - circleDiameter) / 2f,
                ),
            )

            lineProgress(
                gap = 25f,
                color = primaryColor,
                thickness = circleThickness,
                radius = circleRadius,
                center = circleCenter,
                lineThickness = 2.dp,
                numberOfLines = (maxValue - minValue),
                minValue = minValue,
                positionValue = positionValue,
            )

            drawContext.canvas.nativeCanvas.apply {
                drawIntoCanvas {
                    drawText(
                        "$positionValue %",
                        circleCenter.x,
                        circleCenter.y + 45.dp.toPx() / 3f,
                        Paint().apply {
                            textSize = 38.sp.toPx()
                            textAlign = Paint.Align.CENTER
                            color = White.toArgb()
                            isFakeBoldText = true
                        },
                    )
                }
            }
        }
    }
}

private fun DrawScope.lineProgress(
    color: Color,
    gap: Float,
    lineThickness: Dp,
    center: Offset,
    numberOfLines: Int,
    thickness: Float,
    radius: Float,
    minValue: Int,
    positionValue: Int,
) {
    val outerRadius = radius + thickness / 2f

    for (i in 0..numberOfLines) {
        val lineColor = if (i < (positionValue - minValue)) color else color.copy(alpha = 0.3f)
        val angleInDegrees = i * 360f / numberOfLines.toFloat()
        val angleInRad = angleInDegrees * PI / 180f + PI / 2f

        val yGapAdjustment = cos(angleInDegrees * PI / 180f) * gap
        val xGapAdjustment = -sin(angleInDegrees * PI / 180f) * gap

        val start = Offset(
            x = (outerRadius * cos(angleInRad) + center.x + xGapAdjustment).toFloat(),
            y = (outerRadius * sin(angleInRad) + center.y + yGapAdjustment).toFloat(),
        )

        val end = Offset(
            x = (outerRadius * cos(angleInRad) + center.x + xGapAdjustment).toFloat(),
            y = (outerRadius * sin(angleInRad) + thickness + center.y + yGapAdjustment).toFloat(),
        )

        rotate(
            angleInDegrees,
            pivot = start,
        ) {
            drawLine(
                color = lineColor,
                start = start,
                end = end,
                strokeWidth = lineThickness.toPx(),
            )
        }
    }
}

private fun DrawScope.circularProgress(
    color: Color,
    thickness: Float,
    size: Size,
    topLeft: Offset,
    progressPercentage: Float,
) {
    drawArc(
        color = color,
        startAngle = 90f,
        sweepAngle = progressPercentage,
        style = Stroke(
            width = thickness,
            cap = StrokeCap.Round,
        ),
        useCenter = false,
        size = size,
        topLeft = topLeft,
    )
}

private fun DrawScope.circularProgressBase(
    thickness: Float,
    color: Color,
    center: Offset,
    radius: Float,
) {
    drawCircle(
        style = Stroke(
            width = thickness,
        ),
        color = color,
        radius = radius,
        center = center,
    )
}

@Preview(showBackground = true)
@Composable
private fun CircularProgressIndicatorPreview() {
    CircularProgressIndicator(
        modifier = Modifier
            .size(250.dp),
        // .background(darkGray)
        primaryColor = orange,
        secondaryColor = gray,
        circleRadius = 230f,
        onPositionChange = { },
        initialValue = 40,
        minValue = 0,
        maxValue = 100,

    )
}
