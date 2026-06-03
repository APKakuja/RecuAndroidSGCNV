package com.example.recuandroidsgcnv.models

sealed class Estat(val nom: String) {
    object PerLlegir : Estat("Per llegir")
    object Llegint : Estat("Llegint")
    object Llegit : Estat("Llegit")
}