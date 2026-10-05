package com.example.sporthub.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.sporthub.R
import com.example.sporthub.data.Athlete
import com.example.sporthub.data.AthleteRepository
import com.example.sporthub.ui.components.SectionTitle
import com.example.sporthub.ui.components.SportChip

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AthletesScreen(
    onAthleteClick: (Int) -> Unit,
    onFavoritesClick: () -> Unit
) {

    val athletes = AthleteRepository.athletes

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("SportHub")
                }
            )
        }
    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            item {

                Button(
                    onClick = onFavoritesClick,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Favorites")
                }

                Text(
                    text = "Sports",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(
                        top = 16.dp,
                        bottom = 8.dp
                    )
                )

                val sports = listOf(
                    "Football",
                    "Basketball",
                    "Tennis",
                    "Formula 1",
                    "Gymnastics"
                )

                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {

                    items(sports) { sport ->

                        SportChip(
                            sport = sport
                        )
                    }
                }

                SectionTitle(
                    title = "Athletes",
                    modifier = Modifier.padding(
                        top = 16.dp,
                        bottom = 4.dp
                    )
                )
            }

            items(athletes) { athlete ->

                AthleteCard(
                    athlete = athlete,
                    onClick = {
                        onAthleteClick(athlete.id)
                    }
                )
            }
        }
    }
}

@Composable
fun AthleteCard(
    athlete: Athlete,
    onClick: () -> Unit
) {

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            Image(
                painter = painterResource(
                    id = R.drawable.ic_launcher_foreground
                ),
                contentDescription = "Athlete image",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            )

            Text(
                text = athlete.name,
                style = MaterialTheme.typography.titleLarge
            )

            Text(
                text = athlete.sport,
                style = MaterialTheme.typography.bodyLarge
            )

            Text(
                text = athlete.country,
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = athlete.description,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(top = 8.dp)
            )

            Button(
                onClick = onClick,
                modifier = Modifier.padding(top = 8.dp)
            ) {
                Text("View Details")
            }
        }
    }
}