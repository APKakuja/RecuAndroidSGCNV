package com.example.recuandroidsgcnv.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recuandroidsgcnv.R
import com.example.recuandroidsgcnv.models.Llibre

class LlibresAdapter(private val onTascaClick: (Llibre) -> Unit) : RecyclerView.Adapter<LlibreViewHolder>() {

    private var llibres = listOf<Llibre>()

    fun setLlibres(nousLlibres: List<Llibre>) {
        llibres = nousLlibres
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LlibreViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_llibre, parent, false)
        return LlibreViewHolder(view)
    }

    override fun onBindViewHolder(holder: LlibreViewHolder, position: Int) {
        val llibre = llibres[position]
        holder.renderitza(llibre)
        holder.itemView.setOnClickListener {
            onTascaClick(llibre)
        }
    }

    override fun getItemCount(): Int = llibres.size

}
