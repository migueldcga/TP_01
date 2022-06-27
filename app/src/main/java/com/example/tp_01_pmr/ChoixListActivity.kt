package com.example.tp_01_pmr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_01_pmr.adapter.ItemAdapter

class ChoixListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choix_list)

        val dataSet = mutableListOf<String>("cu", "dedo", "buceta","lingua")
        val pseudo = intent.extras?.getString("pseudo") //  en cas si c'est nul ?:""
        val button = findViewById<ImageButton>(R.id.ButtonNouvListe)
        val nouvelleListe = findViewById<EditText>(R.id.NouvelleListe)
        val Listes = findViewById<RecyclerView>(R.id.Listes)
        val adapter = ItemAdapter(dataSet)
        Listes.adapter = adapter
        Listes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)

       // Toast.makeText(this, pseudo , Toast.LENGTH_LONG).show()
        button.setOnClickListener {


            Toast.makeText(this, nouvelleListe.text.toString() , Toast.LENGTH_LONG).show()


        }




    }
}