package com.example.sporthub.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sporthub.data.Athlete

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AthleteDetailScreen(
    athlete: Athlete,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Athlete Details")
                }
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = athlete.name,
                style = MaterialTheme.typography.headlineMedium
            )

            Text(
                text = athlete.sport,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = athlete.country,
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = athlete.description,
                style = MaterialTheme.typography.bodyLarge
            )

            Button(
                onClick = onBack
            ) {
                Text("Back")
            }
        }
    }
}