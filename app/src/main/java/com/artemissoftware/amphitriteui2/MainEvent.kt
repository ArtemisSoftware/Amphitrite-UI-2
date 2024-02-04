package com.artemissoftware.amphitriteui2

sealed class MainEvent {
    data class ThemeChange(val route: String?) : MainEvent()
}
