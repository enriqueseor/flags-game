package com.teknos.flags.menu

import android.widget.Button
import android.widget.TextView
import android.util.DisplayMetrics
import android.app.Activity
import android.content.Context
import kotlin.math.roundToInt

class WidthHeight {

    private val context: Context

    constructor(context: Context,
        width: Int,
        height: Int,
        maxWidth: Int,
        maxHeight: Int,
        c1: Button,
        c2: Button,
        c3: Button,
        c4: Button
    ) {
        this.context = context
        val w = getW(width, maxWidth)
        val h = getH(height, maxHeight)
        c1.width = w
        c2.width = w
        c3.width = w
        c4.width = w
        c1.height = h
        c2.height = h
        c3.height = h
        c4.height = h
    }

    constructor(
        context: Context
    ) {
        this.context = context
    }

    constructor(
        context: Context,
        width: Int,
        height: Int,
        maxWidth: Int,
        maxHeight: Int,
        textView: TextView
    ) {
        this.context = context
        textView.width = getW(width, maxWidth)
        textView.height = getH(height, maxHeight)
    }

    private fun getW(width: Int, maxWidth: Int): Int {
        val metrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(metrics)
        var buttonWidth = (dpToPx(width) * (metrics.widthPixels / 328.80)).toInt()
        buttonWidth = pxToDp(buttonWidth)
        if (buttonWidth > maxWidth) buttonWidth = dpToPx(maxWidth)
        return buttonWidth
    }

    private fun getH(height: Int, maxHeight: Int): Int {
        val metrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(metrics)
        var buttonHeight = (dpToPx(height) * (metrics.heightPixels / 688.80)).toInt()
        buttonHeight = pxToDp(buttonHeight)
        if (buttonHeight > maxHeight) buttonHeight = dpToPx(maxHeight)
        return buttonHeight
    }

    private fun pxToDp(px: Int): Int {
        val displayMetrics = context.resources.displayMetrics
        return (px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()
    }

    private fun dpToPx(dp: Int): Int {
        val displayMetrics = context.resources.displayMetrics
        return (dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT)).roundToInt()
    }
}