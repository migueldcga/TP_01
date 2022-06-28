package com.example.tp_01_pmr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_01_pmr.adapter.AdapterItem
import com.example.tp_01_pmr.adapter.ListAdapter

class ShowListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_list)

        // liste avec des itens deja avec la classe itemToDo
        val dataSet = mutableListOf<String>("terminar tp1","terminar tp2")

        val button = findViewById<ImageButton>(R.id.buttonNvItem)
        val nouvelleListe = findViewById<EditText>(R.id.NouveauItem)
        val Listes = findViewById<RecyclerView>(R.id.Itens)

        // dataset eh do tipo ItemToDo
        val adapter = AdapterItem(dataSet)
        Listes.adapter = adapter
        Listes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)

        // Toast.makeText(this, pseudo , Toast.LENGTH_LONG).show()
        button.setOnClickListener {


            Toast.makeText(this, nouvelleListe.text.toString() , Toast.LENGTH_LONG).show()
            dataSet.add(nouvelleListe.text.toString())

            val adapter = AdapterItem(dataSet)
            Listes.adapter = adapter
            Listes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)


        }


    }
}