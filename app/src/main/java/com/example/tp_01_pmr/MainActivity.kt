package com.example.tp_01_pmr

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.google.android.material.bottomappbar.BottomAppBar

class MainActivity : AppCompatActivity() {

    private val button: Button? = null
    private var typed: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button2)
        val typed = findViewById<EditText>(R.id.entree)

        //Toolbar_standard comme l'original
        val toolbar: Toolbar =findViewById(R.id.toolbar_standard)
        setSupportActionBar(toolbar)
        toolbar.title="Main Activity"


        // verifier si le buton a ete pressi

        button.setOnClickListener {

            val pseudo: String = typed.text.toString()
            // Toast.makeText(this, pseudo, Toast.LENGTH_LONG).show()

            // creer ponte d'info pour la nouvelle activité
            val bundle = Bundle()
            bundle.putString("pseudo", pseudo)

            //
            val intent = Intent(this, ChoixListActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)

        }


    }

    // affiche les actions de preferences sur l'ecran
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.ActionsPreference-> {
//                val pseudo = typed?.text.toString()
//                val bundle = Bundle().apply {
//                    putString("pseudo", pseudo)
//                }
//                val settingsIntent = Intent(this, SettingsActivity::class.java).apply {
//                    putExtras(bundle)
//                }
                val settingsIntent : Intent = Intent(this, SettingsActivity::class.java)
                startActivity(settingsIntent)
            }
        }
        return true
    }
    //



}