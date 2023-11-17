package com.example.grahaksewa.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grahaksewa.domain.model.Grahak
import com.example.grahaksewa.domain.repository.GrahakRepository
import com.example.grahaksewa.util.grahakLog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PreviewViewModel @Inject constructor(
    private val repository: GrahakRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var grahak by mutableStateOf<Grahak?>(null)
    private set

    init{
        val grahakId = savedStateHandle.get<Int>("grahakId")!!
        Log.d(grahakLog, "ID: $grahakId")
        if (grahakId != -1){
            viewModelScope.launch {
                grahak = repository.getGrahakById(grahakId)
                Log.d(grahakLog, "grahak found: $grahak")
            }
        }
    }
}