package com.example.recuandroidsgcnv.data

import com.example.recuandroidsgcnv.models.Estat
import com.example.recuandroidsgcnv.models.Genere
import com.example.recuandroidsgcnv.models.Llibre

object LlibresRepository {
    val llibres = listOf(
        Llibre(1, "Els Pilars de la Terra", "Ken Follett", Genere.Novella, 1989, Estat.Llegit),
        Llibre(2, "Sapiens", "Yuval Noah Harari", Genere.Assaig, 2011, Estat.Llegint),
        Llibre(3, "Maus", "Art Spiegelman", Genere.Comic, 1991, Estat.Llegit),
        Llibre(4, "El nom de la rosa", "Umberto Eco", Genere.Novella, 1980, Estat.PerLlegir),
        Llibre(5, "Breu història del temps", "Stephen Hawking", Genere.Assaig, 1988, Estat.PerLlegir),
        Llibre(6, "Persèpolis", "Marjane Satrapi", Genere.Comic, 2000, Estat.Llegint),
        Llibre(7, "1984", "George Orwell", Genere.Novella, 1949, Estat.Llegit),
        Llibre(8, "Pensa ràpid, pensa a poc a poc", "Daniel Kahneman", Genere.Assaig, 2011, Estat.PerLlegir)
    )
}