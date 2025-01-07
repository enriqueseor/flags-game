package dev.enriqueseor.flags.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import dev.enriqueseor.flags.R

class ActivityMenu : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        setupClickListeners()
    }

    private fun setupClickListeners() {
        findViewById<Button>(R.id.country).setOnClickListener {
            startMode1("FtoCo")
        }

        findViewById<Button>(R.id.capital).setOnClickListener {
            startMode1("FtoCa")
        }

        findViewById<Button>(R.id.flag1).setOnClickListener {
            startMode2("CotoF")
        }

        findViewById<Button>(R.id.flag2).setOnClickListener {
            startMode2("CatoF")
        }
    }

    fun startMode1(mode: String) {
        val myIntent = Intent(this, ActivityMode1::class.java)
        myIntent.putExtra("MODE_TYPE", mode)
        startActivity(myIntent)
    }

    fun startMode2(mode: String) {
        val myIntent = Intent(this, ActivityMode2::class.java)
        myIntent.putExtra("MODE_TYPE", mode)
        startActivity(myIntent)
    }
}