package com.artemissoftware.amphitriteui2.stopwatch

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui2.stopwatch.composables.TimeDisplay
import com.artemissoftware.amphitriteui2.stopwatch.composables.TimerOptions

@Composable
fun StopWatchScreen(viewModel: StopWatchViewModel) {
    StopWatchScreenContent(
        isPlaying = viewModel.isPlaying,
        seconds = viewModel.seconds,
        minutes = viewModel.minutes,
        hours = viewModel.hours,
        onStart = { viewModel.start() },
        onPause = { viewModel.pause() },
        onStop = { viewModel.stop() },
    )
}

@Composable
private fun StopWatchScreenContent(
    isPlaying: Boolean,
    seconds: String,
    minutes: String,
    hours: String,
    onStart: () -> Unit = {},
    onPause: () -> Unit = {},
    onStop: () -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.weight(1f))

        TimeDisplay(
            seconds = seconds,
            minutes = minutes,
            hours = hours,
        )

        Spacer(modifier = Modifier.weight(1f))

        TimerOptions(
            isPlaying = isPlaying,
            onPause = onPause,
            onStart = onStart,
            onStop = onStop,
        )

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun StopWatchScreenContentPreview() {
    StopWatchScreenContent(
        isPlaying = true,
        seconds = "01",
        minutes = "10",
        hours = "11",
    )
}
