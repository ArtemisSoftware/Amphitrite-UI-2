package com.artemissoftware.amphitriteui2

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.artemissoftware.amphitriteui2.multipletheme.MultipleThemeScreens
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _state = MutableStateFlow(MainState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            delay(500L)
            updateReady()
        }
    }

    fun onTriggerEvent(event: MainEvent) {
        when (event) {
            is MainEvent.ThemeChange -> {
                updateTheme(route = event.route)
            }
        }
    }

    private fun updateReady() = with(_state) {
        update {
            it.copy(isReady = true)
        }
    }

    private fun updateTheme(route: String? = null) = with(_state) {
        val theme = MultipleThemeScreens.getTheme(route)
        if (value.theme != theme) {
            update {
                it.copy(theme = theme)
            }
        }
    }
}
