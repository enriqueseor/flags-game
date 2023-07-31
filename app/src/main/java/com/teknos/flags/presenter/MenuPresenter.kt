package com.teknos.flags.presenter

import com.teknos.flags.view.ActivityMenu

class MenuPresenter(private val view: ActivityMenu) {

    fun onCountryModeClicked() {
        startMode1("FtoCo")
    }

    fun onCapitalModeClicked() {
        startMode1("FtoCa")
    }

    fun onFlag1ModeClicked() {
        startMode2("CotoF")
    }

    fun onFlag2ModeClicked() {
        startMode2("CatoF")
    }

    private fun startMode1(mode: String) {
        view.startMode1(mode)
    }

    private fun startMode2(mode: String) {
        view.startMode2(mode)
    }
}