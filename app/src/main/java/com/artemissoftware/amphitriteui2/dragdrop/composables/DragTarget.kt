package com.artemissoftware.amphitriteui2.dragdrop.composables

import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.consumeAllChanges
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import com.artemissoftware.amphitriteui2.dragdrop.models.DragTargetInfo

internal val LocalDragTargetInfo = compositionLocalOf { DragTargetInfo() }

/**
 * All composables wraped with this are draggable
 */
@Composable
fun <T> DragTarget(
    modifier: Modifier = Modifier,
    dataToDrop: T,
    onStartDragging: () -> Unit,
    onStopDragging: () -> Unit,
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
                    onStartDragging()
                    currentState.dataToDrop = dataToDrop
                    currentState.isDragging = true
                    currentState.dragPosition = currentPosition + it
                    currentState.draggableComposable = content
                }, onDrag = { change, dragAmount ->
                    change.consumeAllChanges()
                    currentState.dragOffset += Offset(dragAmount.x, dragAmount.y)
                }, onDragEnd = {
                    onStopDragging()
                    currentState.isDragging = false
                    currentState.dragOffset = Offset.Zero
                }, onDragCancel = {
                    onStopDragging()
                    currentState.dragOffset = Offset.Zero
                    currentState.isDragging = false
                })
            },
    ) {
        content()
    }
}
