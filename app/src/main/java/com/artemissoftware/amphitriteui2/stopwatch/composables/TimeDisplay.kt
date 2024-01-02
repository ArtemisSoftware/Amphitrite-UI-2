package com.artemissoftware.amphitriteui2.stopwatch.composables

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.ContentTransform
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TimeDisplay(
    seconds: String,
    minutes: String,
    hours: String,
) {
    Row {
        val numberTransitionSpec: AnimatedContentTransitionScope<String>.() -> ContentTransform = {
            (slideInVertically(initialOffsetY = { it }) + fadeIn())
                .togetherWith(
                    slideOutVertically(targetOffsetY = { -it }) + fadeOut(),
                )
        }

        CompositionLocalProvider(LocalTextStyle provides MaterialTheme.typography.displayLarge) {
            AnimatedContent(targetState = hours, transitionSpec = numberTransitionSpec, label = "") {
                Text(text = it)
            }
            Text(text = ":")
            AnimatedContent(
                targetState = minutes,
                transitionSpec = numberTransitionSpec,
                label = "",
            ) {
                Text(text = it)
            }
            Text(text = ":")
            AnimatedContent(
                targetState = seconds,
                transitionSpec = numberTransitionSpec,
                label = "",
            ) {
                Text(text = it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TimeDisplayPreview() {
    TimeDisplay(
        seconds = "01",
        minutes = "10",
        hours = "11",
    )
}
