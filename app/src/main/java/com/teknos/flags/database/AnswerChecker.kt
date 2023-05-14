package com.teknos.flags.database

import android.content.Context
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources
import com.teknos.flags.R
import com.teknos.flags.Game
import com.teknos.flags.OppositeGame

class AnswerChecker {
    private var c1: Button? = null
    private var c2: Button? = null
    private var c3: Button? = null
    private var c4: Button? = null
    private var ci1: ImageButton? = null
    private var ci2: ImageButton? = null
    private var ci3: ImageButton? = null
    private var ci4: ImageButton? = null

    constructor(
        context: Context,
        c1: Button?,
        c2: Button?,
        c3: Button?,
        c4: Button?,
        makeQuestion: MakeQuestion,
        choice: Int,
        right: TextView,
        wrong: TextView
    ) {
        this.c1 = c1
        this.c2 = c2
        this.c3 = c3
        this.c4 = c4
        if (choice == makeQuestion.rightAnsPlace) {
            val rightButton = clicked(choice)!!
            rightButton.background = AppCompatResources.getDrawable(context, R.drawable.button_right)
            Game.data?.size?.rem(makeQuestion.countryNum)
            ((right.text as String).toInt() + 1).toString().also { right.text = it }
        } else {
            val rightButton = clicked(makeQuestion.rightAnsPlace)
            val wrongButton = clicked(choice)
            assert(rightButton != null)
            rightButton!!.background = AppCompatResources.getDrawable(context, R.drawable.button_right)
            assert(wrongButton != null)
            wrongButton!!.background = AppCompatResources.getDrawable(context, R.drawable.button_wrong)
            Game.data?.size?.rem(makeQuestion.countryNum+1)
            ((wrong.text as String).toInt() + 1).toString().also { wrong.text = it }
        }
    }

    constructor(
        context: Context,
        c1: ImageButton?,
        c2: ImageButton?,
        c3: ImageButton?,
        c4: ImageButton?,
        makeQuestion: MakeQuestion,
        choice: Int,
        right: TextView,
        wrong: TextView
    ) {
        ci1 = c1
        ci2 = c2
        ci3 = c3
        ci4 = c4
        if (choice == makeQuestion.rightAnsPlace) {
            val rightButton = clickedI(choice)!!
            rightButton.background = AppCompatResources.getDrawable(context, R.drawable.button_right)
            OppositeGame.data?.size?.rem(makeQuestion.countryNum+1)
            ((right.text as String).toInt() + 1).toString().also { right.text = it }
        } else {
            val rightButton = clickedI(makeQuestion.rightAnsPlace)
            val wrongButton = clickedI(choice)
            assert(rightButton != null)
            rightButton!!.background = AppCompatResources.getDrawable(context, R.drawable.button_right)
            assert(wrongButton != null)
            wrongButton!!.background = AppCompatResources.getDrawable(context, R.drawable.button_wrong)
            OppositeGame.data?.size?.rem(makeQuestion.countryNum)
            ((wrong.text as String).toInt() + 1).toString().also { wrong.text = it }
        }
    }

    private fun clicked(choice: Int): Button? {
        return when (choice) {
            0 -> c1
            1 -> c2
            2 -> c3
            3 -> c4
            else -> null
        }
    }

    private fun clickedI(choice: Int): ImageButton? {
        return when (choice) {
            0 -> ci1
            1 -> ci2
            2 -> ci3
            3 -> ci4
            else -> null
        }
    }
}