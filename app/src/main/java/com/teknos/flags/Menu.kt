package com.teknos.flags

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.teknos.flags.menu.IntroMenu
import android.view.View
import android.content.Intent
import com.teknos.flags.singleton.Singleton

class Menu : AppCompatActivity() {

    private var singleton: Singleton? = Singleton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val country = findViewById<Button>(R.id.country)
        val capital = findViewById<Button>(R.id.capital)
        val flag1 = findViewById<Button>(R.id.flag1)
        val flag2 = findViewById<Button>(R.id.flag2)
        val guess = findViewById<TextView>(R.id.guess)
        IntroMenu(this, guess, country, capital, flag1, flag2)
    }

    fun flagToCountryMode(view: View?) {
        val myIntent = Intent(this@Menu, Game::class.java)
        singleton?.type = "FtoCo"
        this@Menu.startActivity(myIntent)
    }

    fun flagToCapitalMode(view: View?) {
        val myIntent = Intent(this@Menu, Game::class.java)
        singleton?.type = "FtoCa"
        this@Menu.startActivity(myIntent)
    }

    fun countryToFlagMode(view: View?) {
        val myIntent = Intent(this@Menu, OppositeGame::class.java)
        singleton?.type = "CotoF"
        this@Menu.startActivity(myIntent)
    }

    fun capitalToFlagMode(view: View?) {
        val myIntent = Intent(this@Menu, OppositeGame::class.java)
        singleton?.type = "CatoF"
        this@Menu.startActivity(myIntent)
    }
}