package com.artemissoftware.amphitriteui2.draggable

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DraggableBox(text: String) {

    Box(
    ){
        val d = LocalDensity.current
        var offsetX by remember { mutableStateOf(0f) }
        var offsetY by remember { mutableStateOf(0f) }
        Box(
            modifier = Modifier
                .offset(x = (offsetX / d.density).dp, y = (offsetY / d.density).dp)
                .background(Color.Red)
                .size(100.dp)
                .pointerInput(Unit) {
                    detectDragGestures { change, dragAmount ->
                        print(dragAmount)
                        change.consume()
                        offsetX += dragAmount.x
                        offsetY += dragAmount.y
                    }
                }
        ){
            Text(
                modifier = Modifier.align(Alignment.Center),
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                text = text
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun DraggableBoxPreview() {
    DraggableBox("1")
}