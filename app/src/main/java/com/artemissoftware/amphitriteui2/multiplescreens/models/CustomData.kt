package com.artemissoftware.amphitriteui2.multiplescreens.models

import androidx.compose.ui.graphics.vector.ImageVector

data class CustomData(
    val id: Int,
    val image: String,
    val title: String,
    val description: String,
    val icons: List<ImageVector>
)