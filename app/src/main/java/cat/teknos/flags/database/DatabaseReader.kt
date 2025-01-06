package cat.teknos.flags.database

import android.content.Context
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper

internal class DatabaseReader(context: Context?) : SQLiteAssetHelper(context, "db3.db", null, 1)