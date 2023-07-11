package com.artemissoftware.amphitriteui2.dragdrop

import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned

internal val LocalDragTargetInfo = compositionLocalOf { DragTargetInfo() }

/**
 * All composables wraped with this are draggable
 */
@Composable
fun <T> DragTarget(
    modifier: Modifier = Modifier,
    dataToDrop: T,
//    viewModel: MainViewModel,
    content: @Composable (() -> Unit),
) {
    var currentPosition by remember { mutableStateOf(Offset.Zero) }
    val currentState = LocalDragTargetInfo.current

    Box(
        modifier = modifier
            .onGloballyPositioned {
                currentPosition = it.localToWindow(
                    Offset.Zero,
                )
            }
            .pointerInput(Unit) {
                detectDragGesturesAfterLongPress(onDragStart = {
//                viewModel.startDragging()
                    currentState.dataToDrop = dataToDrop
                    currentState.isDragging = true
                    currentState.dragPosition = currentPosition + it
                    currentState.draggableComposable = content
                }, onDrag = { change, dragAmount ->
                    change.consumeAllChanges()
                    currentState.dragOffset += Offset(dragAmount.x, dragAmount.y)
                }, onDragEnd = {
//                viewModel.stopDragging()
                    currentState.isDragging = false
                    currentState.dragOffset = Offset.Zero
                }, onDragCancel = {
//                viewModel.stopDragging()
                    currentState.dragOffset = Offset.Zero
                    currentState.isDragging = false
                })
            },
    ) {
        content()
    }
}
