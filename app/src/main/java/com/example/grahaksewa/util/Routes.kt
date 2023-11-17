package com.example.grahaksewa.util

const val grahakLog = "GrahakLog"

sealed class Routes(val route: String) {
    object GRAHAK_LIST : Routes(route = "grahak_list")
    object GRAHAK_ADD : Routes(route = "grahak_add")
    object GRAHAK_PREVIEW : Routes(route = "grahak_view")

    fun withArgsId(id: Int?): String{
        return "${route}?grahakId=${id}"
    }
}