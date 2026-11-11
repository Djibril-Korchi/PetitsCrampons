package com.example.coachfootjeune

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.coachfootjeune.navigation.PetitCramponApp
import com.example.coachfootjeune.ui.theme.CoachFootJeuneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoachFootJeuneTheme {
                PetitCramponApp()
            }
        }
    }
}
