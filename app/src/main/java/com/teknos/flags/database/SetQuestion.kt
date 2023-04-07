package com.teknos.flags.database

import android.content.Context
import android.widget.ImageView
import android.widget.Button
import com.teknos.flags.R
import android.widget.TextView
import android.widget.ImageButton
import androidx.appcompat.content.res.AppCompatResources
import com.teknos.flags.Game
import com.teknos.flags.OppositeGame

class SetQuestion {

    constructor(
        context: Context,
        flag: ImageView,
        c1: Button,
        c2: Button,
        c3: Button,
        c4: Button,
        makeQuestion: MakeQuestion
    ) {
        c1.background = AppCompatResources.getDrawable(context, R.drawable.button)
        c2.background = AppCompatResources.getDrawable(context, R.drawable.button)
        c3.background = AppCompatResources.getDrawable(context, R.drawable.button)
        c4.background = AppCompatResources.getDrawable(context, R.drawable.button)
        makeQuestion.normalMode()
        flag.setImageResource(Game.getResId(makeQuestion.imageName))
        c1.text = makeQuestion.choices[0]
        c2.text = makeQuestion.choices[1]
        c3.text = makeQuestion.choices[2]
        c4.text = makeQuestion.choices[3]
    }

    constructor(
        context: Context,
        country: TextView,
        c1: ImageButton,
        c2: ImageButton,
        c3: ImageButton,
        c4: ImageButton,
        makeQuestion: MakeQuestion
    ) {
        c1.background = AppCompatResources.getDrawable(context, R.drawable.button)
        c2.background = AppCompatResources.getDrawable(context, R.drawable.button)
        c3.background = AppCompatResources.getDrawable(context, R.drawable.button)
        c4.background = AppCompatResources.getDrawable(context, R.drawable.button)
        makeQuestion.oppositeMode()
        country.text = makeQuestion.imageName
        c1.setImageResource(OppositeGame.getResId(makeQuestion.choices[0]))
        c2.setImageResource(OppositeGame.getResId(makeQuestion.choices[1]))
        c3.setImageResource(OppositeGame.getResId(makeQuestion.choices[2]))
        c4.setImageResource(OppositeGame.getResId(makeQuestion.choices[3]))
    }
}