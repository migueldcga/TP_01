package com.example.tp_01_pmr

class ProfileListeToDo (
    private var login: String ="",
    private var mesListesToDo: MutableList<ListeToDo> = mutableListOf<ListeToDo>(ListeToDo(""))

    )
{

    fun getMesListesToDo(): MutableList<ListeToDo> {
        return mesListesToDo;
    }

    fun setMesListesToDo(mesListeToDo: MutableList<ListeToDo>){
        this.mesListesToDo = mesListeToDo
    }

    fun ajouteListe(uneListe: ListeToDo){
        this.mesListesToDo.add(uneListe)
    }

    fun getLogin(): String{
        return this.login;
    }

    fun setLogin(unLogin: String){
        this.login = unLogin
    }

    override fun toString(): String {
        return "pseudo" + login + " : " + mesListesToDo.size + "listes";
    }

}