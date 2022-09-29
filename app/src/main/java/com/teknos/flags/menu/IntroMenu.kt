package com.teknos.flags.menu

import android.content.Context
import android.widget.Button
import android.widget.TextView

class IntroMenu(
    context: Context?,
    guess: TextView,
    country: Button,
    capital: Button,
    flag1: Button,
    flag2: Button
) {
    init {
        if (context != null) {
            WidthHeight(context, 300, 96, 330, 120, guess)
        }
        guess.translationY = -1000f
        country.translationX = -2000f
        capital.translationX = 2000f
        flag1.translationX = -2000f
        flag2.translationX = 2000f
        guess.animate().translationYBy(1000f).duration = 1500
        country.animate().translationXBy(2000f).duration = 1500
        capital.animate().translationXBy(-2000f).duration = 1500
        flag1.animate().translationXBy(2000f).duration = 1500
        flag2.animate().translationXBy(-2000f).duration = 1500
    }
}