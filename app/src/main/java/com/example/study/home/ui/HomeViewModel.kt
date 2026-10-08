package com.example.study.home.ui

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.study.home.domain.usecase.GetAllCharacters
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

class HomeViewModel : ViewModel() {
    private val getAllCharactersUseCase = GetAllCharacters()

    private val _items = MutableStateFlow<List<ListItem>>(listOf(
        ListItem(id = "1", title = "first"),
        ListItem(id = "2", title = "Second"),
        ListItem(id = "3", title = "Thrid"),
        ListItem(id = "4", title = "Fourth"),
        ListItem(id = "5", title = "Fiveth"),
        ListItem(id = "6", title = "Fiveth"),
        ListItem(id = "7", title = "Fiveth"),
        ListItem(id = "8", title = "Fiveth"),
        ListItem(id = "9", title = "Fiveth"),
        ListItem(id = "10", title = "Fiveth"),
        ListItem(id = "11", title = "Fiveth"),
        ListItem(id = "12", title = "Fiveth"),
        ListItem(id = "13", title = "Fiveth"),
        ListItem(id = "14", title = "Fiveth"),
        ListItem(id = "15", title = "Fiveth"),
        ListItem(id = "16", title = "Fiveth"),
        ListItem(id = "17", title = "Fiveth"),
        ListItem(id = "18", title = "Fiveth"),
        ListItem(id = "19", title = "Fiveth"),
        ListItem(id = "20", title = "Fiveth"),
        ListItem(id = "21", title = "Fiveth"),
        ListItem(id = "22", title = "Fiveth"),
        ListItem(id = "23", title = "Fiveth"),
        ListItem(id = "24", title = "Fiveth"),
    ))
    val items: StateFlow<List<ListItem>> = _items

    private val _currentTime = MutableStateFlow(System.currentTimeMillis())
    val currentTime: StateFlow<Long> = _currentTime

    init {
        viewModelScope.launch {
            while (true) {
                delay(1000.milliseconds)
                _currentTime.value = System.currentTimeMillis()
            }
        }
    }



    fun startTimeForItem(itemId: String) {
        val currentItems = _items.value.toMutableList()
        val index = currentItems.indexOfFirst { it.id == itemId }

        if (index != -1 && currentItems[index].startTime == null) {
            currentItems[index] = currentItems[index].copy(
                startTime = System.currentTimeMillis()
            )
            _items.value = currentItems
        }
    }

    fun getAllCharacters() {
        viewModelScope.launch {
            getAllCharactersUseCase.getAllCharactersUseCase()
            println("REsulttt --> ${getAllCharactersUseCase.getAllCharactersUseCase()}")
        }
    }
}

data class ListItem(
    val id: String,
    val title: String,
    val startTime: Long? = null
)