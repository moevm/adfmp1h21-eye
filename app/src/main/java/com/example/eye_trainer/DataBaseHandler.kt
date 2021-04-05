package com.example.eye_trainer

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "eye_trainer_records"
val TABLE_NAME = "LeaderShip"
val COL_NAME = "Name"
val COL_SCORE = "Score"
val COL_ID = "id"

class DataBaseHandler (var context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, 1){
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLE_NAME + " ( " +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COL_NAME + " VARCHAR(256), " +
                COL_SCORE + " INTEGER)"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun insertData(name: String, score: Int){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME, name)
        cv.put(COL_SCORE, score)
        db.insert(TABLE_NAME, null, cv)
        //Toast.makeText(context, "Added", Toast.LENGTH_SHORT).show()
    }

    fun readData() : MutableList<User>{
        var list : MutableList<User> = ArrayList()

        val db = this.readableDatabase
        val query = "Select * from " + TABLE_NAME
        val result = db.rawQuery(query,null)
        if (result.moveToFirst()){
            do {
                var user = User()
                user.id = result.getString(result.getColumnIndex(COL_ID)).toInt()
                user.name = result.getString(result.getColumnIndex(COL_NAME))
                user.score = result.getString(result.getColumnIndex(COL_SCORE)).toInt()
                list.add(user)
            }while (result.moveToNext())
        }
        result.close()
        db.close()

        return list
    }

    fun deleteData(){
        val db = writableDatabase
        db.delete(TABLE_NAME, null, null)
    }

    fun updateData(name: String, score: Int){
        val db = this.writableDatabase
        val query = "Select * from " + TABLE_NAME
        var check: Int = 0
        val result = db.rawQuery(query,null)
        var cv = ContentValues()
        cv.put(COL_NAME, name)
        cv.put(COL_SCORE, score)
        if (result.moveToFirst()){
            do {
                check = db.update(TABLE_NAME, cv, COL_NAME + "=?", arrayOf(name))
            }while (result.moveToNext())
        }
        if (check == 0){
            db.insert(TABLE_NAME, null, cv)
        }
        //Toast.makeText(context, "check = ${check}", Toast.LENGTH_SHORT).show()
        result.close()
        db.close()
    }

}