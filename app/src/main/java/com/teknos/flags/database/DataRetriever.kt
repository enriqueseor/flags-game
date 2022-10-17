package com.teknos.flags.database

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import java.util.ArrayList

class DataRetriever(context: Context?, mode: String) {
    private val openHelper: SQLiteOpenHelper
    private val mode: String
    val data: List<Country>
        get() {
            val database = openHelper.readableDatabase
            val data: MutableList<Country> = ArrayList()
            val cursor = database.rawQuery("SELECT * FROM data", null)
            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                if ((mode == "FtoCa" || mode == "CatoF") && cursor.getString(2) == "") {
                    cursor.moveToNext()
                    continue
                }
                data.add(
                    Country(
                        cursor.getString(0).toInt(),
                        cursor.getString(1),
                        cursor.getString(2),
                        cursor.getString(3)
                    )
                )
                cursor.moveToNext()
            }
            cursor.close()
            database.close()
            return data
        }

    init {
        openHelper = DatabaseReader(context)
        this.mode = mode
    }
}
