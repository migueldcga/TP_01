package com.example.tp_01_pmr

import android.content.Intent
import android.content.SharedPreferences
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
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {

    private val button: Button? = null

    //    private var typed: EditText? = null
    private var sharedPreferences: SharedPreferences? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        sharedPreferences = getSharedPreferences("Profiles", 0)

        val button = findViewById<Button>(R.id.button2)
        var typed = findViewById<EditText>(R.id.entree)

        //Toolbar_standard comme l'original
        val toolbar: Toolbar = findViewById(R.id.toolbar_standard)
        setSupportActionBar(toolbar)
        toolbar.title = "Main Activity"


        // verifier si le buton a ete pressi

        button.setOnClickListener {


            var pseudo: String = typed.text.toString()
//            Toast.makeText(this, "cu" , Toast.LENGTH_LONG).show()

//             creer un nouvel utilisateur avec sa nouvelle liste si necessaire
            if (sharedPreferences?.contains(pseudo) == false) {
                Toast.makeText(this, "inedito" , Toast.LENGTH_LONG).show()
                val profile = ProfileListeToDo(pseudo)
                val listToDo = ListeToDo("Liste 0")
                val dataSet = mutableListOf<ListeToDo> (listToDo)
                profile.setMesListesToDo(dataSet)
                val profileGson = Gson().toJson(profile)
                sharedPreferences?.edit()?.apply() {
                    putString(pseudo, profileGson)
                    apply()
                }
            }

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
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.ActionsPreference -> {

                // pseudo mis par le utilisateur
//                val pseudo = typed?.text.toString()

                // partager les infos avec l'activite ChoixListActivity
//                val bundle = Bundle().apply {
//                    putString("pseudo", pseudo)
//            }
//                val settingsIntent = Intent(this, SettingsActivity::class.java).apply {
//                    putExtras(bundle)

                val settingsIntent
                        : Intent = Intent(this, SettingsActivity::class.java)
                startActivity(settingsIntent)
//            }


            }
            //

        }
        return true
    }
}



