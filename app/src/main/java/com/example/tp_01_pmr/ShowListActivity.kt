package com.example.tp_01_pmr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tp_01_pmr.adapter.AdapterItem

class ShowListActivity : AppCompatActivity() {

    private var nouvelItem: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_list)

        // liste avec des itens deja avec la classe itemToDo

        val dataSet = mutableListOf<String>("terminar tp1","terminar tp2")

        val button = findViewById<ImageButton>(R.id.buttonNvItem)
        val nouvelItem = findViewById<EditText>(R.id.NouveauItem)
        val Items = findViewById<RecyclerView>(R.id.Itens)

        //Toolbar_standard comme l'original
        val toolbar: Toolbar =findViewById(R.id.toolbar_standard)
        setSupportActionBar(toolbar)
        toolbar.title="Show List Activity"


        // dataset eh do tipo ItemToDo
        val adapter = AdapterItem(dataSet)
        Items.adapter = adapter
        Items.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)

        // Toast.makeText(this, pseudo , Toast.LENGTH_LONG).show()
        button.setOnClickListener {


            Toast.makeText(
                this,
                nouvelItem.text.toString(),
                Toast.LENGTH_LONG
            ).show()
            dataSet.add(nouvelItem.text.toString())

            val adapter = AdapterItem(dataSet)
            Items.adapter = adapter
            Items.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)


        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.ActionsPreference-> {
                val pseudo = nouvelItem?.text.toString()
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