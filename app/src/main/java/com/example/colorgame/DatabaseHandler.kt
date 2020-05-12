package com.example.colorgame

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

val DATABASE_NAME = "color_game_storage"
val TABLE_NAME = "users"
val COL_ID = "id"
val COL_NAME = "name"
val COL_POINTS = "points"

class DatabaseHandler(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, 1)
{

    override fun onCreate(db: SQLiteDatabase?) {
        val TABLE = "CREATE TABLE "+ TABLE_NAME + " ( "+COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_NAME + " VARCHAR(256), " + COL_POINTS + " INTEGER )"
        db?.execSQL(TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



    fun insertData(user: User)
    {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME, user.name)
        cv.put(COL_POINTS, user.points)
        db.insert(TABLE_NAME, null, cv)
    }

    fun readData() : MutableList<User> {
        var list : MutableList<User> = ArrayList()

        val db = this.readableDatabase
        val query = "SELECT * FROM "+ TABLE_NAME
        val result = db.rawQuery(query, null)

        if (result.moveToFirst())
        {
            do {
                var user = User()
                user.id = result.getString(0).toInt()
                user.name = result.getString(1)
                user.points = result.getString(2).toInt()
                list.add(user)
            }while (result.moveToNext())
        }

        result.close()
        db.close()

        return list
    }
}
