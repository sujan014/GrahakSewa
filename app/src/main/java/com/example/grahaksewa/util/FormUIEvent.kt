package com.example.grahaksewa.util

sealed class FormUIEvent{
    data class FormMessage( val message: String) : FormUIEvent()
}
