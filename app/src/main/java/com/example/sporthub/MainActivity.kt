package com.example.sporthub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.sporthub.navigation.SportHubNavigation
import com.example.sporthub.ui.theme.SportHubTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            SportHubTheme {
                SportHubNavigation()
            }
        }
    }
}