package com.artemissoftware.amphitriteui2.epoch


import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.artemissoftware.amphitriteui2.epoch.composables.Cable
import com.artemissoftware.amphitriteui2.epoch.composables.CircularCountDown
import com.artemissoftware.amphitriteui2.epoch.composables.updateCircularTransitionData
import com.artemissoftware.amphitriteui2.ui.theme.*

@Composable
fun EpochScreen(viewModel: EpochViewModel) {

    var progress by remember { mutableStateOf(0f) }
    val currentTime = viewModel.currentTime.collectAsState().value
    val isRunning = viewModel.isRunning.collectAsState().value
    val transitionData = updateCircularTransitionData(
        remainingTime = currentTime,
        totalTime = EpochViewModel.TOTAL_TIME
    )

    /**
     * animation state for On and Off arc
     * @param transitionData
     */

    val default = animateFloatAsState(
        targetValue = if (isRunning) transitionData.progress else 0f,
        animationSpec = tween(300, easing = LinearEasing)
    )
    progress = default.value

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = blueBG),
        contentAlignment = Alignment.Center
    ) {

        Cable(
            onStartClicked = { viewModel.onStartClicked() },
            onResetClicked = { viewModel.onResetClicked() },
            isRunning = isRunning,
        )
        CircularCountDown(currentTime, progress)
    }
}

@Preview(showBackground = true)
@Composable
private fun EpochScreenPreview() {
    val viewModel: EpochViewModel = viewModel()
    EpochScreen(viewModel)
}


