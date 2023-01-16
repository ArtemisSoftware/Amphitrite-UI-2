package com.artemissoftware.amphitriteui2.epoch.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.inset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui2.epoch.util.Constants
import com.artemissoftware.amphitriteui2.epoch.util.Constants.getFormattedTime
import com.artemissoftware.amphitriteui2.ui.theme.*

@Composable
fun CircularCountDown() {

    var progress by remember { mutableStateOf(0f) }

    val currentTime = 10L//viewModel.currentTime.collectAsState().value

    Box(
        modifier = Modifier
            .wrapContentSize()
            .background(color = blueBG),
        contentAlignment = Alignment.Center
    ) {

        CountDown(progress = progress)
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = getFormattedTime(millis = currentTime),
            color = whiteText,
            style = MaterialTheme.typography.h4
        )
    }
}


@Composable
private fun CountDown(progress: Float) {
    Canvas(
        modifier = Modifier
            .wrapContentSize()
            .background(color = blueBG)
    ) {

        inset(size.width / 2 - Constants.TIMER_RADIUS, size.height / 2 - Constants.TIMER_RADIUS) {

            val gradientBrush = Brush.linearGradient(listOf(blue500, blue200, blue400))

            drawArc(
                brush = gradientBrush,
                startAngle = 270f,
                sweepAngle = progress,
                useCenter = false,
                style = Stroke(width = 100f, cap = StrokeCap.Round),
                blendMode = BlendMode.SrcIn
            )

            drawCircle(
                color = card,
                radius = Constants.TIMER_RADIUS,
                center = center,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CountDownPreview() {
    Box(
        modifier = Modifier
            .size(300.dp),
        contentAlignment = Alignment.Center
    ) {
        CountDown(180f)
    }
}


@Preview(showBackground = true)
@Composable
private fun CircularCountDownPreview() {
    CircularCountDown()
}