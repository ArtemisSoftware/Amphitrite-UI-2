package com.artemissoftware.amphitriteui2.epoch.composables

import android.annotation.SuppressLint
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.artemissoftware.amphitriteui2.R
import com.artemissoftware.amphitriteui2.ui.theme.card
import com.artemissoftware.amphitriteui2.ui.theme.deepGold
import kotlin.math.roundToInt

/**
 * CableView contains three Box layout which stacked up on each other view.
 * Box 1 is the root layout which acts as an draggable view.
 * Box 2 is cable with dynamic height. It means whenever we drag the root Box 1 layout height
 * of this layout be calculated calculated accordingly
 * Box 3 which contains flash icon inside. Color of this flash icon is handled according to the offset.
 * @param viewModel
 * @param isRunning
 */
@Composable
fun Cable(
    //--viewModel: MainViewModel,
    isRunning: Boolean
) {

//    /**
//     * states for icon color, run check & cable wire offset
//     */
    var iconColor by remember { mutableStateOf(Color.Gray) }
    val isRunningNow by remember { mutableStateOf(isRunning) }
    var offsetY by remember { mutableStateOf(1600f) }

    iconColor = if (offsetY <= 1200) {
        deepGold
    } else {
        Color.Gray
    }

    /**
     * composable state for cable wire height
     */
    val animatedHeightState = animateDpAsState(
        targetValue = if (offsetY <= 1200) offsetY.dp else offsetY.dp,
        animationSpec = tween(300, easing = LinearEasing)
    )

    /**
     * composable state for cable color
     */
    val animatedColor = animateColorAsState(
        targetValue = iconColor,
        animationSpec = tween(300, easing = LinearEasing)
    )

    // Box1 - Root Layout
    Box(
        modifier = Modifier
            .offset { IntOffset(0, offsetY.roundToInt()) }
            .draggable(
                orientation = Orientation.Vertical,
                state = rememberDraggableState(
                    onDelta = {
                        offsetY += it
                    }
                ),
                onDragStopped = {
                    if (offsetY <= 1200) {
                        offsetY = 1200f
                        if (isRunningNow) {
//                            viewModel.onResetClicked()
                        } else {
//                            viewModel.onStartClicked()
                        }
                    } else {
                        offsetY = 1600f
//                        viewModel.onResetClicked()
                    }
                }
            )
            .fillMaxSize()
            .animateContentSize(),
        contentAlignment = Alignment.BottomCenter
    ) {

        CableWire(
            iconColor = animatedColor,
            cableHeight = animatedHeightState
        )
    }
}

@Composable
private fun CableWire(iconColor: State<Color>, cableHeight: State<Dp>) {
    Box(
        Modifier
            .size(20.dp, cableHeight.value)
            .background(card),
    ) {

        ChargerPin()
        CableHead(iconColor = iconColor)
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
private fun CableWirePreview() {
    CableWire(iconColor = mutableStateOf(Color.Green), cableHeight = mutableStateOf(100.dp))
}

@Composable
private fun CableHead(iconColor: State<Color>) {

    Box(
        modifier = Modifier
            .requiredSize(100.dp)
            .clip(RoundedCornerShape(4.dp))
            .padding(0.dp, 20.dp, 0.dp, 0.dp)
            .background(card),
        contentAlignment = Alignment.Center
    ) {

        IconButton(onClick = { }) {
            val icon = painterResource(id = R.drawable.ic_lightning)
            Icon(
                painter = icon,
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp),
                tint = iconColor.value
            )
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(showBackground = true)
@Composable
private fun CableHeadPreview() {
    CableHead(iconColor = mutableStateOf(Color.Yellow))
}


@Preview(showBackground = true)
@Composable
private fun CablePreview() {
    Cable(
        isRunning = true
    )
}