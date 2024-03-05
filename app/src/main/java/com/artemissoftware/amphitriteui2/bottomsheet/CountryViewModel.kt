package com.artemissoftware.amphitriteui2.bottomsheet

import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.artemissoftware.amphitriteui2.bottomsheet.models.Country
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor() : ViewModel() {

    private val _tasks = MutableStateFlow<List<Task>>(emptyList())
    val tasks: StateFlow<List<Task>> get() = _tasks

    private val _state = MutableStateFlow<ItemTask>(ItemTask())
    val state: StateFlow<ItemTask> = _state.asStateFlow()

    init {

        _tasks.value = listOf(
            Task(1, "Task 1"),
            Task(2, "Task 2"),
            Task(3, "Task 3"),
        )

        _state.value = ItemTask(
            tasks = listOf(
                Task(1, "Task 1"),
                Task(2, "Task 2"),
                Task(3, "Task 3"),
            ),
        )
    }

    fun incrementInList(id: Int) = with(_state) {
        update { itemTask ->
            itemTask.copy(
                tasks = _state.value.tasks.map {
                    if (it.id == id) {
                        it.copy(isCompleted = true, clicks = it.clicks + 1)
                    } else {
                        it
                    }
                },
            )
        }

//        _state.value = _state.value.copy(
//            tasks = _state.value.tasks.map {
//                if (it.id == id) {
//                    it.copy(isCompleted = true, clicks = it.clicks + 1)
//                } else {
//                    it
//                }
//            },
//        )

//        update {
//            value.tasks.map {
//                if (it.id == id) {
//                    it.copy(isCompleted = true, clicks = it.clicks + 1)
//                } else {
//                    it
//                }
//            }
//        }

//        _tasks.value = _tasks.value.map {
//            if (it.id == id) {
//                it.copy(isCompleted = true, clicks = it.clicks + 1)
//            } else {
//                it
//            }
//        }
    }

    fun increment(id: Int) = with(_tasks) {
        update {
            value.map {
                if (it.id == id) {
                    it.copy(isCompleted = true, clicks = it.clicks + 1)
                } else {
                    it
                }
            }
        }

//        _tasks.value = _tasks.value.map {
//            if (it.id == id) {
//                it.copy(isCompleted = true, clicks = it.clicks + 1)
//            } else {
//                it
//            }
//        }
    }

    fun incrementLike(name: String) {
        _tasks.value = _tasks.value.map {
            if (it.id == 1) {
                it.copy(isCompleted = true)
            } else {
                it
            }
        }

//        _countries.value.countries = _countries.value.countries.map {
//            if (it.name == name) {
//                it.copy(like = ++it.like)
//            } else {
//                it
//            }
//        }
//
//        _countries.value.countries =

//        val list = _countries.value.countries.toMutableList()
//        val ff: List<Country> = list.mapIndexed { j, item ->
//            if (name == item.name) {
//                item.copy(like = ++item.like)
//            } else {
//                item
//            }
//        }.toMutableList()
//        val newList = listOf(
//            Country(
//                name = "India",
//                flag = "\uD83C\uDDEE\uD83C\uDDF3",
//                like = 0,
//            ),
//        )
//        list.addAll(newList)
//
//        _countries.update {
//            it.copy(
//                countries = ff//ff.toMutableList(),
//            )
//        }

//        _countries.value.mapIndexed { j, item ->
//            if (name == item.name) {
//                item.copy(like = ++item.like)
//            } else {
//                item
//            }
//        }

//        _countries.value.add(
//            Country(
//                name = "India",
//                flag = "\\uD83C\\uDDEE\\uD83C\\uDDF3",
//                like = 0,
//            ),
//        )
//        val country = _countries.value.find { it.name == name }
//        country?.let {
//            val lolo = _countries.value.toMutableList()
//            val index = _countries.value.indexOf(it)
//
//            ++lolo[index].like
//            _countries.value = lolo.toList()
//        }
//        //_counter.intValue++
    }
}

data class Task(
    val id: Int,
    var name: String,
    var isCompleted: Boolean = false,
    var clicks: Int = 0,
)
data class ItemTask(
    var tasks: List<Task> = emptyList<Task>(),
)

data class Item(val weight: Int)
data class AllCont(
    var countries: List<Country> = emptyList<Country>(),
)
