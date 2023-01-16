package com.artemissoftware.amphitriteui2.epoch.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun ChargerPin() {
    Box(
        Modifier
            .requiredSize(60.dp)
            .clip(RoundedCornerShape(12.dp, 12.dp, 0.dp, 0.dp))
            .background(Color.Gray)
    )
}

@Preview(showBackground = true)
@Composable
private fun ChargerPinPreview() {
    ChargerPin()
}