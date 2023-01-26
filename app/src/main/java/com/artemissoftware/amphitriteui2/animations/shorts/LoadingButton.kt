package com.artemissoftware.amphitriteui2.animations.shorts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class ButtonState { NORMAL, LOADING }

@Composable
fun LoadingButton(
    onClick: () -> Unit,
    text: String,
    state: ButtonState
) {

    var sizeText by remember { mutableStateOf(IntSize.Zero) }
    val textWidth = with(LocalDensity.current){
        (sizeText.width).toDp()
    }
    val textHeight = with(LocalDensity.current){
        (sizeText.height).toDp()
    }

    Button(
        onClick = onClick,
        modifier = Modifier.height(60.dp)
    ) {
        if (state == ButtonState.NORMAL) {
            Text(
                text,
                fontSize = 20.sp,
                modifier = Modifier
                    .onGloballyPositioned {
                        sizeText = it.size
                    }
            )
        } else {
            Box(
                modifier = Modifier
                    .size(
                        width = textWidth,
                        height = textHeight
                    ),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = Color.Yellow)
            }
        }
    }
}

@Composable
fun LoadingButton_(
    onClick: () -> Unit,
    text: String,
    state: ButtonState
) {

    var sizeText by remember { mutableStateOf(IntSize.Zero) }
    val textWidth = with(LocalDensity.current){
        (sizeText.width).toDp()
    }
    val textHeight = with(LocalDensity.current){
        (sizeText.height).toDp()
    }

    Button(
        onClick = onClick,
        modifier = Modifier.height(60.dp)
    ) {
//        if (state == ButtonState.NORMAL) {
//            Text(
//                text,
//                fontSize = 16.sp,
//                modifier = Modifier
//                    .onGloballyPositioned {
//                        sizeText = it.size
//                    }
//            )
//        } else {
            Box(
                modifier = Modifier
                    .size(
                        width = 16.dp,
                        height = 16.dp
                    ),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(color = Color.Yellow)
            }
//        }
    }
}


@Preview(showBackground = true)
@Composable
private fun LoadingButtonPreview() {

    Column{
        LoadingButton(
            text = "amphitriteui2.animations.shorts",
            onClick = {},
            state = ButtonState.NORMAL
        )

        LoadingButton(
            text = "amphitriteui2.animations.shorts",
            onClick = {},
            state = ButtonState.LOADING
        )
        var state by remember { mutableStateOf(ButtonState.NORMAL) }

        LoadingButton_(
            text = "amphitriteui2.animations.shorts",
            onClick = {
                state = if(state == ButtonState.NORMAL) ButtonState.LOADING else ButtonState.NORMAL
            },
            state = state
        )

        Box(
            modifier = Modifier
                .size(
                    width = 200.dp,
                    height = 60.dp
                ).background(color = Color.Blue),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(color = Color.Yellow)

            Text(
                "amphitriteui2.animations.shorts",
                fontSize = 16.sp,
                modifier = Modifier

            )
        }
    }

}