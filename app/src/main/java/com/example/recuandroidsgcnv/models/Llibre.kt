package com.example.recuandroidsgcnv.models

data class Llibre(
    val id: Int,
    val titol: String,
    val autor: String,
    val genere: Genere,
    val any: Int,
    val estat: Estat
)