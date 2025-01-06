package cat.teknos.flags.database

import android.content.Context
import android.database.sqlite.SQLiteOpenHelper
import cat.teknos.flags.model.Country
import java.util.ArrayList

class DataRetriever(context: Context?, private val mode: String) {

    private val openHelper: SQLiteOpenHelper = DatabaseReader(context)

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
}