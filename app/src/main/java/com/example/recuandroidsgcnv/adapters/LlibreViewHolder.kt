package com.example.recuandroidsgcnv.adapters

import android.graphics.Color
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recuandroidsgcnv.R
import com.example.recuandroidsgcnv.models.Estat
import com.example.recuandroidsgcnv.models.Llibre

class LlibreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val lbTitol: TextView = itemView.findViewById(R.id.fragmentContainer)
    private val lbAutor: TextView = itemView.findViewById(R.id.fragmentContainer)
    private val lbGenere: TextView = itemView.findViewById(R.id.fragmentContainer)
    private val lbAny: TextView = itemView.findViewById(R.id.fragmentContainer)
    private val tvEstat: TextView = itemView.findViewById(R.id.fragmentContainer)


    fun renderitza(llibre: Llibre) {
        lbTitol.text = llibre.titol
        lbAutor.text = llibre.autor
        lbGenere.text = llibre.genere as CharSequence?
        lbAny.text = llibre.any as CharSequence?
        tvEstat.text = llibre.estat as CharSequence?

        val color = when (llibre.estat) {
            is Estat.PerLlegir -> Color.parseColor("#FFA500")
            is Estat.Llegint -> Color.parseColor("#0000FF")
            is Estat.Llegit -> Color.parseColor("#008000")
        }
        tvEstat.setTextColor(color)
    }
}