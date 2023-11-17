package com.example.grahaksewa.presentation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.grahaksewa.presentation.formpage.Form
import com.example.grahaksewa.presentation.mainpage.GrahakMain
import com.example.grahaksewa.presentation.previewpage.PreviewPage
import com.example.grahaksewa.util.Routes

@Composable
fun GrahakAppNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.GRAHAK_LIST.route){
        composable(route = Routes.GRAHAK_LIST.route){
            GrahakMain(
                navController = navController
            )
        }
        composable(route = Routes.GRAHAK_ADD.route + "?grahakId={grahakId}",
            arguments = listOf(
                navArgument(name="grahakId"){
                    type=NavType.IntType
                    defaultValue = -1
                }
            )
        ){
            Form(
                navController = navController
            )
        }
        composable(
            route = Routes.GRAHAK_PREVIEW.route + "?grahakId={grahakId}",
            arguments = listOf(
                navArgument(name="grahakId"){
                    type = NavType.IntType
                    defaultValue = -1
                }
            )
        ){
            PreviewPage(
                navController = navController
            )
        }
    }
}