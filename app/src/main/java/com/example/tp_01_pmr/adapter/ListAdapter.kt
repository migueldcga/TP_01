package com.example.tp_01_pmr.adapter

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_01_pmr.ChoixListActivity
import com.example.tp_01_pmr.ShowListActivity


class ListAdapter(private val dataSet: MutableList<String>) : RecyclerView.Adapter<ListAdapter.ItemViewHolder>(),View.OnClickListener {

    override fun getItemCount(): Int = dataSet.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val itemView = TextView(parent.context)
        itemView.setOnClickListener(this)
        //         LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(itemView)


    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        holder.bind(dataSet[position])

    }

    override fun onClick(view: View) {

        val recyclerV = view.parent as RecyclerView
        val listTdIndex = recyclerV.getChildLayoutPosition(view)


        val bundle = Bundle().apply {
            putInt("listTD index", listTdIndex)
        }
        val intentList = Intent(view.context, ShowListActivity::class.java).apply {
            putExtras(bundle)
        }
        intentList.putExtras(bundle)
        view.context.startActivity(intentList)
        

    }




class ItemViewHolder(private val itemView : View) : RecyclerView.ViewHolder(itemView){

    fun bind (text : String){

        val conteudo = itemView as TextView
        conteudo.text = text

    }
}

}

