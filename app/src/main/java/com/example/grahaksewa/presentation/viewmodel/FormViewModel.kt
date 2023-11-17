package com.example.grahaksewa.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.grahaksewa.domain.model.Grahak
import com.example.grahaksewa.domain.repository.GrahakRepository
import com.example.grahaksewa.util.FormUIEvent
import com.example.grahaksewa.util.containsOnlyNumber
import com.example.grahaksewa.util.grahakLog
import com.example.grahaksewa.util.valueIsEntered
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FormViewModel @Inject constructor(
    private val repository: GrahakRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var grahak by mutableStateOf<Grahak?>(null)
    private set

    private val _formUIEvent: Channel<FormUIEvent> = Channel<FormUIEvent>()
    var formUIEvent: Flow<FormUIEvent> = _formUIEvent.receiveAsFlow()

    private fun FormEvent(formEvent: FormUIEvent){
        viewModelScope.launch {
            _formUIEvent.send(formEvent)
        }
    }

    var firstName by mutableStateOf("")
    var middleName by mutableStateOf("")
    var lastName by mutableStateOf("")
    var cityAddress by mutableStateOf("")
    var localAddress by mutableStateOf("")
    var wardNo by mutableStateOf("")
    var maal by mutableStateOf("")
    var description by mutableStateOf("")
    var tola by mutableStateOf("")
    var carat by mutableStateOf("")
    var dateTime by mutableStateOf("")

    var currentId: Int? = null
    init{
        val grahakId = savedStateHandle.get<Int>("grahakId")!!
        if (grahakId != -1){
            viewModelScope.launch {
                grahak = repository.getGrahakById(grahakId)?.also {
                    currentId = it.id

                    firstName = it.firstName
                    middleName = it.middleName
                    lastName = it.lastName
                    cityAddress = it.cityAddress
                    localAddress = it.localAddress
                    wardNo = it.wardNo.toString()
                    maal = it.maal
                    description = it.description
                    tola = it.tola.toString()
                    carat = it.carat.toString()
                    dateTime = it.dateTime
                }
                Log.d(grahakLog, "grahak found: $grahak")
            }
        }
    }

    fun onDeleteEvent(){
        firstName = ""
        middleName = ""
        lastName = ""
        cityAddress = ""
        localAddress = ""
        wardNo = ""
        maal = ""
        description = ""
        tola = ""
        carat = ""
        dateTime = ""
    }

    fun onAddNewEvent(){
        if ( !firstName.valueIsEntered() )
        {
            //Log.d(grahakLog, "first name not entered")
            FormEvent(FormUIEvent.FormMessage("first name not entered"))
            return
        }
        if (!lastName.valueIsEntered())
        {
            FormEvent(FormUIEvent.FormMessage("last name not entered"))
            //Log.d(grahakLog, "last name not entered")
            return
        }
        if (!cityAddress.valueIsEntered())
        {
            FormEvent(FormUIEvent.FormMessage("City Address is not entered"))
            //Log.d(grahakLog, "city address not entered")
            return
        }
        if (!localAddress.valueIsEntered())
        {
            FormEvent(FormUIEvent.FormMessage("Local address is not entered"))
            //Log.d(grahakLog, "local address not entered")
            return
        }
        if (!wardNo.containsOnlyNumber())
        {
            FormEvent(FormUIEvent.FormMessage("Ward number is not entered"))
            //Log.d(grahakLog, "ward no not entered")
            return
        }
        if (!maal.valueIsEntered())
        {
            FormEvent(FormUIEvent.FormMessage("Maal(Item) is not entered"))
            //Log.d(grahakLog, "maal not entered")
            return
        }
        if (!tola.containsOnlyNumber())
        {
            FormEvent(FormUIEvent.FormMessage("Tola is not entered"))
            //Log.d(grahakLog, "tola not entered")
            return
        }
        if (!carat.containsOnlyNumber())
        {
            FormEvent(FormUIEvent.FormMessage("Carat is not entered"))
            //Log.d(grahakLog, "carat not entered")
            return
        }
        if (!dateTime.valueIsEntered())
        {
            FormEvent(FormUIEvent.FormMessage("Date is not entered"))
            //Log.d(grahakLog, "date not entered")
            return
        }
        viewModelScope.launch {
            try {
                val newGrahak = Grahak(
                    id = currentId,
                    firstName = firstName,
                    middleName = middleName,
                    lastName = lastName,
                    cityAddress = cityAddress,
                    localAddress = localAddress,
                    wardNo = wardNo.toInt(),
                    maal = maal,
                    description = description,
                    tola = tola.toInt(),
                    carat = carat.toInt(),
                    dateTime = dateTime
                )
                repository.insertGrahak(newGrahak)
                FormEvent(FormUIEvent.FormMessage("${newGrahak.firstName} ${newGrahak.middleName} ${newGrahak.lastName} is saved"))
                //Log.d(grahakLog, "$newGrahak Successfully added")
            }
            catch (ex: Exception){
                ex.message?.let { Log.d(grahakLog, it) }
            }
        }
    }
}