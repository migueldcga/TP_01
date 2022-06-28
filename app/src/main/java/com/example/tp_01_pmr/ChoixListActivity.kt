package com.example.tp_01_pmr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_01_pmr.adapter.ListAdapter

class ChoixListActivity : AppCompatActivity() {

    val button: ImageButton? = null
    val nouvelleListe: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choix_list)

        val button = findViewById<ImageButton>(R.id.ButtonNouveauItem)
        val nouvelleListe = findViewById<EditText>(R.id.NouvelleItem)
        val Listes = findViewById<RecyclerView>(R.id.Items2)


        val dataSet = mutableListOf<String>("cu", "dedo", "buceta","lingua")
        val pseudo = intent.extras?.getString("pseudo") //  en cas si c'est nul ?:""

        val adapter = ListAdapter(dataSet)
        Listes.adapter = adapter
        Listes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)

       // Toast.makeText(this, pseudo , Toast.LENGTH_LONG).show()
        button.setOnClickListener {


            Toast.makeText(this, nouvelleListe.text.toString() , Toast.LENGTH_LONG).show()
            dataSet.add(nouvelleListe.text.toString())

            val adapter = ListAdapter(dataSet)
            Listes.adapter = adapter
            Listes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)


        }




    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.ActionsPreference-> {
                val pseudo = nouvelleListe?.text.toString()
                val bundle = Bundle().apply {
                    putString("pseudo", pseudo)
                }
                val settingsIntent = Intent(this, SettingsActivity::class.java).apply {
                    putExtras(bundle)
                }
                startActivity(settingsIntent)
            }
        }
        return true
    }
}