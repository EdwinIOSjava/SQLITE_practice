package com.example.sqlite_practice

class Task (
    //recibe:
    var id:Long,
    var title:String,
    var done:Boolean
){
    // creamos constantes que represnten las columnas de las tareas BD

     companion object{
         const val TABLE_NAME = "Tasks"
         const val COLUMN_ID = "id"
         const val COLUMN_TITLE = "title"
         const val COLUMN_DONE = "done"

     }
}