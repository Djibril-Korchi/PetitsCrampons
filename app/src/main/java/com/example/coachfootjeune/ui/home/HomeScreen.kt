package com.example.coachfootjeune.ui.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.coachfootjeune.navigation.OngletAccueil

@Composable
fun HomeScreen(
    ongletSelectionne: OngletAccueil,
    onSelectOnglet: (OngletAccueil) -> Unit,
    content: @Composable () -> Unit,
) {
    val titre = when (ongletSelectionne) {
        OngletAccueil.EFFECTIF -> "Effectif"
        OngletAccueil.MATCH -> "Match en cours"
        OngletAccueil.HISTORIQUE -> "Historique"
    }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        topBar = {
            Row(
                modifier = Modifier.fillMaxWidth().statusBarsPadding().padding(horizontal = 24.dp, vertical = 18.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Surface(
                    modifier = Modifier.size(48.dp),
                    color = MaterialTheme.colorScheme.primaryContainer,
                    shape = MaterialTheme.shapes.medium,
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(Icons.Default.SportsSoccer, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    }
                }
                Column {
                    Text("PETIT CRAMPON", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.primary)
                    Text(titre, style = MaterialTheme.typography.headlineSmall)
                }
            }
        },
        bottomBar = {
            NavigationBar(containerColor = MaterialTheme.colorScheme.surface, tonalElevation = 8.dp) {
                OngletAccueil.entries.forEach { onglet ->
                    NavigationBarItem(
                        selected = onglet == ongletSelectionne,
                        onClick = { onSelectOnglet(onglet) },
                        icon = { Icon(onglet.icone, contentDescription = null) },
                        label = { Text(onglet.libelle) },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = MaterialTheme.colorScheme.primary,
                            selectedTextColor = MaterialTheme.colorScheme.primary,
                            indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                            unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                            unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                        ),
                    )
                }
            }
        },
    ) { innerPadding ->
        Box(modifier = Modifier.fillMaxSize().padding(innerPadding)) { content() }
    }
}
