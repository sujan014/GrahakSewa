package com.example.grahaksewa.util

/*
    . -> any kind of character
    * -> any amount of any kind of characters
    //d -> one number
    + -> at least one
    [A-Z] -> Upper case
    [a-z] -> Lower case\
    ^ -> Other characters not in the range following it
 */

fun String.containsOnlyNumber(): Boolean{
    val regex = Regex("\\d+")
    return regex.matches(this) // this -> current string
}

fun String.containsUpperCase():Boolean{
    val regex = Regex(".*[A-Z]+.*")
    return regex.matches(this)
}

fun String.containsSpecialChar(): Boolean{
    val regex = Regex(".*[^A-Za-z\\d]+.*")
    return regex.matches(this)
}

fun String.valueIsEntered(): Boolean{
    if (isNotBlank() && isNotEmpty())
        return true
    return false
}