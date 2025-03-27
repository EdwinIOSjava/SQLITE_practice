package com.example.sqlite_practice
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper



class DatabaseManager(context:Context):SQLiteOpenHelper(context,DATABASE_NAME,null,DATABASE_VERSION) {
    companion object{
        const val DATABASE_NAME = "ToDoList2.db"
        const val DATABASE_VERSION = 1

        private const val SQL_CREATE_TABLE_TASK=
            "CREATE TABLE ${Task.TABLE_NAME} (" +
                    "${Task.COLUMN_ID} INTEGER PRIMARY KEY AUTOINCREMENT,"+
                    "${Task.COLUMN_TITLE} TEXT NOT NULL,"+
                    "${Task.COLUMN_DONE} BOOLEAN NOT NULL)"

        private const val SQL_DROP_TABLE_TASK="DROP TABLE IF EXISTS ${Task.TABLE_NAME}" // BORRA LA TABLA SI EXISTE Y LE DAMOS EL NOMRBRE DE LA TABLA
    }


    override fun onCreate(db: SQLiteDatabase) {
        //RECIBO LA BASE DE DATOS Y CREO LA TABLA
        db.execSQL(SQL_CREATE_TABLE_TASK) // creo la TABLA
    }


    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        onDestroy(db)
        onCreate(db)
    }
    fun onDestroy(db: SQLiteDatabase){
        db.execSQL(SQL_DROP_TABLE_TASK)// como solo hay datos de pruebas no hay problema, pero  si hubiera usuarios y cosas esto NO SE HACE
    }

    // todo pendiente: showbyID  y show ALL
}