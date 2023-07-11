package com.artemissoftware.amphitriteui2.dragdrop

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.artemissoftware.amphitriteui2.dragdrop.models.Person

class DragDropViewModel : ViewModel() {

    var isCurrentlyDragging by mutableStateOf(false)
        private set

    var items by mutableStateOf(emptyList<Person>())
        private set

    var addedPersons = mutableStateListOf<Person>()
        private set

    init {
        items = listOf(
            Person("Michael", "1", Color.Gray),
            Person("Larissa", "2", Color.Blue),
            Person("Marc", "3", Color.Green),
        )
    }

    fun startDragging() {
        isCurrentlyDragging = true
    }
    fun stopDragging() {
        isCurrentlyDragging = false
    }

    fun addPerson(personUiItem: Person) {
        println("Added Person")
        addedPersons.add(personUiItem)
    }
}
