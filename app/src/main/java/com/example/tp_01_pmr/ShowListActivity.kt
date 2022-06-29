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
import com.example.tp_01_pmr.adapter.AdapterItem
import com.google.gson.Gson

class ShowListActivity : AppCompatActivity() {

    private var nouvelItem: EditText? = null
    private var sharedPreferences: SharedPreferences? = null
    private var profile: ProfileListeToDo? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_list)

        val button = findViewById<ImageButton>(R.id.buttonNvItem)
        val nouvelItem = findViewById<EditText>(R.id.NouveauItem)
        val Items = findViewById<RecyclerView>(R.id.Itens)
        var dataSet: MutableList<ItemToDo>? = null



        //Toolbar_standard comme l'original
        val toolbar: Toolbar =findViewById(R.id.toolbar_standard)
        setSupportActionBar(toolbar)
        toolbar.title="Show List Activity"



        // information de l'autre activité
        val pseudo = intent.extras?.getString("pseudo") //  en cas si c'est nul ?:""
        val listToDoIndex = intent.extras?.getInt("listeToDo index")


        //donnes du profil
        sharedPreferences = getSharedPreferences("Profiles",0)
        val jsonProfile = sharedPreferences?.getString(pseudo,"DEFAULT")

        profile = Gson().fromJson(jsonProfile, ProfileListeToDo::class.java)
        var listToDo: ListeToDo? = profile?.getMesListesToDo()?.get(listToDoIndex!!)

        dataSet = listToDo?.getLesItems()
        // liste avec des itens deja avec la classe itemToDo

//        val dataSet = mutableListOf<ItemToDo>(ItemToDo("Item 0", true))




        // dataset eh do tipo ItemToDo
        val adapter = AdapterItem(dataSet!!, profile!!)
        Items.adapter = adapter
        Items.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL ,false)

        // Toast.makeText(this, pseudo , Toast.LENGTH_LONG).show()
        button.setOnClickListener {


            Toast.makeText(
                this,
                nouvelItem.text.toString(),
                Toast.LENGTH_LONG
            ).show()
//            dataSet.add(nouvelItem.text.toString())
            val itemToDo = ItemToDo(nouvelItem.text.toString(),false)
            dataSet.add(itemToDo)

            // refreshing the screen with the new item
            Items.adapter?.notifyItemInserted(dataSet!!.size -1)

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