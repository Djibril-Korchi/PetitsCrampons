package com.example.coachfootjeune.domain.model

enum class EventType(val libelle: String) {
    BUT("But"),
    BUT_ADVERSE("But adverse"),
    FAUTE("Faute"),
    CHANGEMENT("Changement"),
    BLESSURE("Blessure"),
    DEBUT_PERIODE("Début de période"),
    FIN_PERIODE("Fin de période"),
}
