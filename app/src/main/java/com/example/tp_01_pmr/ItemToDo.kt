package com.example.tp_01_pmr

class ItemToDo
    (
    private var description: String = "",
    private var fait: Boolean = false
    )


{    fun setDescription(novelDescription: String){
        description = novelDescription;
    }

    fun getDescription(): String{
        return this.description;
    }

    fun setFait(NovelFait: Boolean){
        fait = NovelFait
    }

    fun getFait(): Boolean{
        return this.fait;
    }

    override fun toString(): String {
        return "- " + description + " : " + "fait ->" + (if(fait) "oui" else "non");
    }
}