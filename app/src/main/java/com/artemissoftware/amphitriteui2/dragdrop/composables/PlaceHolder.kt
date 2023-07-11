package com.artemissoftware.amphitriteui2.dragdrop.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PlaceHolder(
    isInBound: Boolean,
) {
    val boxBorderColor = if (isInBound) Color.Red else Color.White
    val boxColor = if (isInBound) Color.Gray.copy(0.5f) else Color.Black.copy(0.5f)
    val textColor = if (isInBound) Color.Red else Color.White

    Box(
        modifier = Modifier
            .fillMaxSize()
            .border(
                1.dp,
                color = boxBorderColor,
                shape = RoundedCornerShape(15.dp),
            )
            .background(color = boxColor, shape = RoundedCornerShape(15.dp)),
        contentAlignment = Alignment.Center,
    ) {
        Text(
            text = "Add Person",
            style = MaterialTheme.typography.body1,
            color = textColor,
        )
    }
}
