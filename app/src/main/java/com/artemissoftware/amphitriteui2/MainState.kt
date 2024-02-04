package com.artemissoftware.amphitriteui2

import com.artemissoftware.amphitriteui2.ui.theme.ThemeType

data class MainState(
    val theme: ThemeType = ThemeType.Default,
    val isReady: Boolean = false,
)
