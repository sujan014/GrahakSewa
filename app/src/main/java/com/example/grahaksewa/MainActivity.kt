package com.example.grahaksewa

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.grahaksewa.presentation.GrahakAppNavigation
import com.example.grahaksewa.presentation.mainpage.GrahakMain
import com.example.grahaksewa.ui.theme.GrahakSewaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GrahakSewaTheme {
                // A surface container using the 'background' color from the theme
                GrahakAppNavigation()
            }
        }
    }
}
