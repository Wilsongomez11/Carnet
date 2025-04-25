package com.example.carnet

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val petViewModel: PetViewModel = viewModel()

            NavHost(navController, startDestination = "screenA") {
                composable("screenA") { ScreenA(navController, petViewModel) }
                composable("screenB") { ScreenB(petViewModel) }
            }
        }
    }
}

