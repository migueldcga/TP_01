package com.example.tp_01_pmr.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_01_pmr.R


class ItemAdapter(private val dataSet: MutableList<String>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    override fun getItemCount(): Int = dataSet.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val itemView = TextView(parent.context)
   //         LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder( itemView)



    }
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int)
    {

    holder.bind(dataSet[position])





    }


class ItemViewHolder(private val itemView : View) : RecyclerView.ViewHolder(itemView){

    fun bind (text : String){

        val conteudo = itemView as TextView
        conteudo.text = text

    }
}

}

