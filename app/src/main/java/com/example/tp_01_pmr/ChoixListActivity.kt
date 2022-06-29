package com.example.tp_01_pmr

import android.content.Intent
import android.content.SharedPreferences
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
import com.example.tp_01_pmr.adapter.ListAdapter
import com.google.gson.Gson

class ChoixListActivity : AppCompatActivity() {

    private var sharedPreferences: SharedPreferences? = null
    private var profile: ProfileListeToDo? = null
//    private var dataSet: MutableList<ListeToDo>? = null
//    private val Listes = findViewById<RecyclerView>(R.id.Items2)

    val button: ImageButton? = null
//    private var nouvelleListe: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choix_list)

//        var dataSet: MutableList<ListeToDo>? = null
        sharedPreferences = getSharedPreferences("Profiles",0)

        // lien avec le layout
        val button = findViewById<ImageButton>(R.id.ButtonNouveauItem)
//        val nouvelleListe = findViewById<EditText>(R.id.NouvelleItem)
//        val Listes = findViewById<RecyclerView>(R.id.Items2)
        var dataSet: MutableList<ListeToDo>? = null


        //Toolbar_standard comme l'original
        val toolbar: Toolbar =findViewById(R.id.toolbar_standard)
        setSupportActionBar(toolbar)
        toolbar.title="Choix List Activity"

        //les donnés sauvegardé du profil seront chargé
        val pseudo = intent.extras?.getString("pseudo") //  en cas si c'est nul ?:""
//        Toast.makeText(this, pseudo , Toast.LENGTH_LONG).show()

        val jsonProfile = sharedPreferences?.getString(pseudo,"DEFAULT")
        profile = Gson().fromJson(jsonProfile, ProfileListeToDo::class.java)

        dataSet = profile?.getMesListesToDo()

//        val listToDo = ListeToDo("Liste 0")
//        val dataSet = mutableListOf<ListeToDo> (listToDo)
//

//        dataSet.add(listToDo)

        val Listes = findViewById<RecyclerView?>(R.id.Items2)
        Listes?.adapter  = ListAdapter(dataSet!!,profile!!)
        Listes?.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

//        val dataSet = mutableListOf<String>("cu", "dedo", "buceta","lingua")

//
//        val adapter = ListAdapter(dataSet)
//        Listes.adapter = adapter
//        Listes.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)

       // Toast.makeText(this, pseudo , Toast.LENGTH_LONG).show()
        button.setOnClickListener {
            val nouvelleListe: EditText? = findViewById<EditText>(R.id.NouvelleItem)

            val listToDo = ListeToDo(nouvelleListe?.text.toString())
            Toast.makeText(this, nouvelleListe?.text.toString() , Toast.LENGTH_LONG).show()

            dataSet!!.add(listToDo)
            Listes.adapter?.notifyItemInserted(dataSet!!.size -1)

            // Sauvegarder les nouvelles informations

            val profileGson = Gson().toJson(profile)
            sharedPreferences?.edit()?.apply {
                putString(profile?.getLogin(), profileGson)
                apply()
            }


        }




    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.ActionsPreference-> {
//                val pseudo = nouvelleListe?.text.toString()
//                val bundle = Bundle().apply {
//                    putString("pseudo", pseudo)
//                }
//                val settingsIntent = Intent(this, SettingsActivity::class.java).apply {
//                    putExtras(bundle)
//                }
                 val settingsIntent: Intent = Intent(this, SettingsActivity::class.java)
                startActivity(settingsIntent)
            }
        }
        return true
    }
}