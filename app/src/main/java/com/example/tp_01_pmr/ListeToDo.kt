package com.example.tp_01_pmr

class ListeToDo (
    private var titreListeToDo: String ="",
        )
{

    private var lesItems: MutableList<ItemToDo> = mutableListOf<ItemToDo>(ItemToDo())
    fun setTitreListToDo(titre: String) {
        this.titreListeToDo = titre
    }

    fun getTitreListToDo(): String {
        return this.titreListeToDo
    }

    fun setLesItems(lesItems: MutableList<ItemToDo>) {
        this.lesItems = lesItems
    }

    fun getLesItems(): MutableList<ItemToDo> {
        return this.lesItems
    }

    override fun toString(): String {
        return "Liste" + titreListeToDo + " : " + lesItems.size + "listes";
    }
}