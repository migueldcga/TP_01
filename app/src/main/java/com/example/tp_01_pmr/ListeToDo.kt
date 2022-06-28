package com.example.tp_01_pmr

class ListeToDo (
    private var titreListToDo: String ="",
    private var lesItems: MutableList<ItemToDo> = mutableListOf<ItemToDo>(ItemToDo())
    )
{
    fun setTitreListToDo(titre: String) {
        this.titreListToDo = titre
    }

    fun getTitreListToDo(): String {
        return this.titreListToDo
    }


    override fun toString(): String {
        return "{\"titreListToDo\": \"${titreListToDo}\", \"lesItems\": ${lesItems}}"
    }
}