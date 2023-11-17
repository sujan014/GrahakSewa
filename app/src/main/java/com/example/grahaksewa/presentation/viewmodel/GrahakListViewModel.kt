package com.example.grahaksewa.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grahaksewa.domain.model.Grahak
import com.example.grahaksewa.domain.repository.GrahakRepository
import com.example.grahaksewa.util.grahakLog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Delay
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GrahakListViewModel @Inject constructor(
    private val repository: GrahakRepository
): ViewModel() {
    private val _searchText = MutableStateFlow("")
    val searchText: StateFlow<String> = _searchText.asStateFlow()

    //var grahakList: Flow<List<Grahak>> = repository.getAllGrahak()
    private val _grahakList: Flow<List<Grahak>> = repository.getAllGrahak()
    @OptIn(FlowPreview::class)
    val grahakList: Flow<List<Grahak>> = searchText
        .debounce(1000L)// this will add debounce delay before other operators are executed
        // if searchText changes before delay ends, remaining operators will be cancelled
        // .update -> to make threadsafe
        .combine(_grahakList) { text: String, persons ->
            if (text.isBlank()){
                persons
            } else {
                persons.filter{
                    it.queryName(text)
                }
            }
        }

    //var scope: Job? = null
    fun onSearchTextChange(text: String){
        _searchText.value = text
    }

    fun onDelete(grahak: Grahak){
        viewModelScope.launch {
            repository.deleteGrahak(grahak)
        }
    }

    fun onDeleteAll()
    {
        viewModelScope.launch {
            repository.deleteAll()
        }
    }
}