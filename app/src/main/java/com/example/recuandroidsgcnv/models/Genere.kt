package com.example.recuandroidsgcnv.models

sealed class Genere(val nom: String) {
    object Novella : Genere("Novel·la")
    object Assaig : Genere("Assaig")
    object Comic : Genere("Còmic")
}