package com.teknos.flags.database

import android.content.Context
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper

internal class DatabaseReader(context: Context?) : SQLiteAssetHelper(context, "database.db", null, 1)