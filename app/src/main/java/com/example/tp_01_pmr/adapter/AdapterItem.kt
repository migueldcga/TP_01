package com.example.tp_01_pmr.adapter

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_01_pmr.ShowListActivity


class AdapterItem(private val dataSet: MutableList<String>) : RecyclerView.Adapter<AdapterItem.ItemViewHolder>(),View.OnClickListener {

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

        val recyclerView = view.parent as RecyclerView
        val listTdIndex = recyclerView.getChildLayoutPosition(view)

        val intentList = Intent(view.context, ShowListActivity::class.java)
//        intent.putExtras(bundle)
        view.context.startActivity(intentList)
    }




    class ItemViewHolder(private val itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bind (text : String){

            val conteudo = itemView as TextView
            conteudo.text = text

        }
    }

}

