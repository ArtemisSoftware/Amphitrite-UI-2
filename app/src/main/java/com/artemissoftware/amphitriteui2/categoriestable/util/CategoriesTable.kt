package com.artemissoftware.amphitriteui2.categoriestable.util

import com.artemissoftware.amphitriteui2.ui.theme.LightGreen40
import com.artemissoftware.amphitriteui2.ui.theme.Red40
import com.artemissoftware.amphitriteui2.ui.theme.Yellow40

fun Int.percentageToColor() = when {
    this < 50 -> Red40
    this < 90 -> Yellow40
    else -> LightGreen40
}

