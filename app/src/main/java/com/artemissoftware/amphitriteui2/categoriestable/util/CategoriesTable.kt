package com.artemissoftware.amphitriteui2.categoriestable.util

import com.artemissoftware.amphitriteui2.ui.theme.LightGreen40
import com.artemissoftware.amphitriteui2.ui.theme.Red40
import com.artemissoftware.amphitriteui2.ui.theme.Yellow40

fun Int.percentageToColor() = when {
    this < 90 -> LightGreen40
    this < 99 -> Yellow40
    else -> Red40
}