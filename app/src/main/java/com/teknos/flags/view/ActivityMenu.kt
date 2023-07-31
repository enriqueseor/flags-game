package com.teknos.flags.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import com.teknos.flags.R
import com.teknos.flags.presenter.MenuPresenter

class ActivityMenu : AppCompatActivity() {
    private lateinit var presenter: MenuPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        presenter = MenuPresenter(this)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        findViewById<Button>(R.id.country).setOnClickListener {
            presenter.onCountryModeClicked()
        }

        findViewById<Button>(R.id.capital).setOnClickListener {
            presenter.onCapitalModeClicked()
        }

        findViewById<Button>(R.id.flag1).setOnClickListener {
            presenter.onFlag1ModeClicked()
        }

        findViewById<Button>(R.id.flag2).setOnClickListener {
            presenter.onFlag2ModeClicked()
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