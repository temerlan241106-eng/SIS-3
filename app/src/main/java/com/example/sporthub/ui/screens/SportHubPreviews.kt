package com.example.sporthub.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.sporthub.data.Athlete
import com.example.sporthub.ui.theme.SportHubTheme

@Preview(showBackground = true)
@Composable
fun AthleteCardPreview() {

    SportHubTheme {

        AthleteCard(
            athlete = Athlete(
                id = 1,
                name = "Cristiano Ronaldo",
                sport = "Football",
                country = "Portugal",
                description = "Professional football player."
            ),
            onClick = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SportHubPreview() {

    SportHubTheme {

        AthletesScreen(
            onAthleteClick = {},
            onFavoritesClick = {}
        )
    }
}

@Preview(
    showBackground = true,
    name = "Dark Mode Preview"
)
@Composable
fun SportHubDarkPreview() {

    SportHubTheme(
        darkTheme = true
    ) {

        AthleteCard(
            athlete = Athlete(
                id = 1,
                name = "Cristiano Ronaldo",
                sport = "Football",
                country = "Portugal",
                description = "Professional football player."
            ),
            onClick = {}
        )
    }
}