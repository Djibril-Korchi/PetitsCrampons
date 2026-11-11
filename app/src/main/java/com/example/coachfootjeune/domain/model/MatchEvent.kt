package com.example.coachfootjeune.domain.model

data class MatchEvent(
    val id: Long = 0,
    val minute: Int,
    val type: EventType,
    val joueurId: Long? = null,
    val commentaire: String? = null,
)
