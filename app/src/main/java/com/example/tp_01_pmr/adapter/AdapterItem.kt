package com.example.tp_01_pmr.adapter

import android.content.Intent
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_01_pmr.ShowListActivity
import android.widget.CheckBox
import com.example.tp_01_pmr.ItemToDo
import com.example.tp_01_pmr.ProfileListeToDo
import com.google.gson.Gson


class AdapterItem(private val dataSet: MutableList<ItemToDo>,
                  private val profile: ProfileListeToDo
) : RecyclerView.Adapter<AdapterItem.ItemViewHolder>(),View.OnClickListener {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val itemView = CheckBox(parent.context)
        itemView.setOnClickListener(this)
        //         LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(itemView)


    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        holder.bind(dataSet[position])

    }

    override fun onClick(view: View) {

        val recyclerView = view.parent as RecyclerView
        val listTodoIndex = recyclerView.getChildLayoutPosition(view)
        val checkBox = view as CheckBox
        val intentList = Intent(view.context, ShowListActivity::class.java)

        dataSet[listTodoIndex].setFait(checkBox.isChecked)


        val sharedPreferences = view.context.getSharedPreferences("Profiles",0)
        val profileGson = Gson().toJson(profile)
        sharedPreferences?.edit()?.apply {
            putString(profile.getLogin(), profileGson)
            apply()
        }
    }

    override fun getItemCount(): Int = dataSet.size





    class ItemViewHolder(private val itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bind (text : ItemToDo){

            val conteudo = itemView as CheckBox
            conteudo?.text = text.getDescription()
            conteudo?.isChecked = text.getFait()

        }
    }

}

