package com.teknos.flags.database

import android.content.Context
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper

internal class DatabaseReader(context: Context?) : SQLiteAssetHelper(context, "db.db", null, 1)