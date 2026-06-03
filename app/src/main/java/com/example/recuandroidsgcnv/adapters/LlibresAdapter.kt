package com.example.recuandroidsgcnv.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recuandroidsgcnv.R
import com.example.recuandroidsgcnv.models.Llibre

class LlibresAdapter : RecyclerView.Adapter<LlibreViewHolder>() {

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
        holder.renderitza(llibres[position])
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}