package com.teknos.flags

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.widget.Button
import com.teknos.flags.singleton.Singleton

class Menu : AppCompatActivity() {

    private var singleton: Singleton? = Singleton

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
            val myIntent = Intent(this@Menu, Game::class.java)
            singleton?.type = "FtoCo"
            this@Menu.startActivity(myIntent)
        }
    }

    private fun flagToCapitalMode() {
        val btn = findViewById<Button>(R.id.capital)
        btn.setOnClickListener {
            val myIntent = Intent(this@Menu, Game::class.java)
            singleton?.type = "FtoCa"
            this@Menu.startActivity(myIntent)
        }
    }

    private fun countryToFlagMode() {
        val btn = findViewById<Button>(R.id.flag1)
        btn.setOnClickListener {
            val myIntent = Intent(this@Menu, OppositeGame::class.java)
            singleton?.type = "CotoF"
            this@Menu.startActivity(myIntent)
        }
    }

    private fun capitalToFlagMode() {
        val btn = findViewById<Button>(R.id.flag2)
        btn.setOnClickListener {
            val myIntent = Intent(this@Menu, OppositeGame::class.java)
            singleton?.type = "CatoF"
            this@Menu.startActivity(myIntent)
        }
    }
}