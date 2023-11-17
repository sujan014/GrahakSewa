package com.example.grahaksewa.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Grahak(
    @PrimaryKey
    val id: Int? = null,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val cityAddress: String,
    val localAddress: String,
    val wardNo: Int,
    val maal: String,
    val description: String,
    val tola: Int,
    val carat: Int,
    val dateTime: String
) {
    fun queryName(text: String): Boolean {
        return (firstName.contains(text, ignoreCase = true) ||
                middleName.contains(text, ignoreCase = true) ||
                lastName.contains(text, ignoreCase = true))
    }
}
