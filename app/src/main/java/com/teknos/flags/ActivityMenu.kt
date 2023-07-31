package com.teknos.flags

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button

class ActivityMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        flagToCountryMode()
        flagToCapitalMode()
        countryToFlagMode()
        capitalToFlagMode()
    }

    private fun flagToCountryMode() {
        val btn = findViewById<Button>(R.id.country)
        btn.setOnClickListener {
            startGameActivity("FtoCo")
        }
    }

    private fun flagToCapitalMode() {
        val btn = findViewById<Button>(R.id.capital)
        btn.setOnClickListener {
            startGameActivity("FtoCa")
        }
    }

    private fun countryToFlagMode() {
        val btn = findViewById<Button>(R.id.flag1)
        btn.setOnClickListener {
            startOppositeGameActivity("CotoF")
        }
    }

    private fun capitalToFlagMode() {
        val btn = findViewById<Button>(R.id.flag2)
        btn.setOnClickListener {
            startOppositeGameActivity("CatoF")
        }
    }

    private fun startGameActivity(mode: String) {
        val myIntent = Intent(this@ActivityMenu, ActivityGame::class.java)
        myIntent.putExtra("MODE_TYPE", mode)
        this@ActivityMenu.startActivity(myIntent)
    }

    private fun startOppositeGameActivity(mode: String) {
        val myIntent = Intent(this@ActivityMenu, ActivityOppositeGame::class.java)
        myIntent.putExtra("MODE_TYPE", mode)
        this@ActivityMenu.startActivity(myIntent)
    }
}