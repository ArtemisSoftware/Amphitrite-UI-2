package com.artemissoftware.amphitriteui2.dragdrop

import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.artemissoftware.amphitriteui2.dragdrop.models.Person
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class DragDropViewModel : ViewModel() {

    private var _state = MutableStateFlow(value = DragDropState())
    val state = _state.asStateFlow()

    init {
        _state.update {
            it.copy(
                items = listOf(
                    Person("Michael", "1", Color.Gray),
                    Person("Larissa", "2", Color.Blue),
                    Person("Marc", "3", Color.Green),
                ),
            )
        }
    }

    fun startDragging() {
        _state.update {
            it.copy(isCurrentlyDragging = true)
        }
    }
    fun stopDragging() {
        _state.update {
            it.copy(isCurrentlyDragging = false)
        }
    }

    fun addPerson(personUiItem: Person) {
        val list = _state.value.addedPersons.toMutableList()
        list.add(personUiItem)
        _state.update {
            it.copy(addedPersons = list)
        }
    }
}

data class DragDropState(
    val isCurrentlyDragging: Boolean = false,
    val items: List<Person> = emptyList(),
    val addedPersons: List<Person> = emptyList(),
)
