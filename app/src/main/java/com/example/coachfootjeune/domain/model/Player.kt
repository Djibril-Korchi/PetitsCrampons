package com.example.coachfootjeune.domain.model

data class Player(
    val id: Long = 0,
    val prenom: String,
    val numeroMaillot: Int,
    val postePrefere: Poste? = null,
    val estGardien: Boolean = false,
    val estPresent: Boolean = true,
    val estArchive: Boolean = false,
)
