package com.example.coachfootjeune.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.ui.graphics.vector.ImageVector

object Destinations {
    const val CONNEXION = "connexion"
    const val EFFECTIF = "effectif"
    const val MATCH = "match"
    const val HISTORIQUE = "historique"
    const val DETAIL_MATCH = "detail/{matchId}"

    fun detailMatch(matchId: Long) = "detail/$matchId"
}

enum class OngletAccueil(val route: String, val libelle: String, val icone: ImageVector) {
    EFFECTIF(Destinations.EFFECTIF, "Effectif", Icons.Default.Groups),
    MATCH(Destinations.MATCH, "Match", Icons.Default.SportsSoccer),
    HISTORIQUE(Destinations.HISTORIQUE, "Historique", Icons.Default.History),
}
