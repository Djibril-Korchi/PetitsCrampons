package com.example.coachfootjeune.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.coachfootjeune.ui.history.HistoryScreen
import com.example.coachfootjeune.ui.home.HomeScreen
import com.example.coachfootjeune.ui.login.LoginScreen
import com.example.coachfootjeune.ui.match.MatchScreen
import com.example.coachfootjeune.ui.players.PlayersScreen

@Composable
fun PetitCramponApp() {
    val navController = rememberNavController()
    val selectOnglet: (OngletAccueil) -> Unit = { onglet ->
        navController.navigate(onglet.route) {
            popUpTo(Destinations.EFFECTIF) { saveState = true }
            launchSingleTop = true
            restoreState = true
        }
    }

    NavHost(navController = navController, startDestination = Destinations.CONNEXION) {
        composable(Destinations.CONNEXION) {
            LoginScreen(onLogin = {
                navController.navigate(Destinations.EFFECTIF) {
                    popUpTo(Destinations.CONNEXION) { inclusive = true }
                    launchSingleTop = true
                }
            })
        }
        composable(Destinations.EFFECTIF) {
            HomeScreen(ongletSelectionne = OngletAccueil.EFFECTIF, onSelectOnglet = selectOnglet) {
                PlayersScreen()
            }
        }
        composable(Destinations.MATCH) {
            HomeScreen(ongletSelectionne = OngletAccueil.MATCH, onSelectOnglet = selectOnglet) {
                MatchScreen()
            }
        }
        composable(Destinations.HISTORIQUE) {
            HomeScreen(ongletSelectionne = OngletAccueil.HISTORIQUE, onSelectOnglet = selectOnglet) {
                HistoryScreen()
            }
        }
        composable(
            route = Destinations.DETAIL_MATCH,
            arguments = listOf(navArgument("matchId") { type = NavType.LongType }),
        ) { entry ->
            val matchId = entry.arguments?.getLong("matchId")

            HomeScreen(ongletSelectionne = OngletAccueil.HISTORIQUE, onSelectOnglet = selectOnglet) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Détail du match n°$matchId", style = MaterialTheme.typography.headlineMedium)
                }
            }
        }
    }
}
