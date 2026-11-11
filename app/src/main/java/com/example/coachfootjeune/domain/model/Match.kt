package com.example.coachfootjeune.domain.model

import java.time.LocalDate

data class Match(
    val id: Long = 0,
    val date: LocalDate = LocalDate.now(),
    val adversaire: String,
    val format: MatchFormat = MatchFormat.A_HUIT,
    val scoreEquipe: Int = 0,
    val scoreAdversaire: Int = 0,
    val evenements: List<MatchEvent> = emptyList(),
)
