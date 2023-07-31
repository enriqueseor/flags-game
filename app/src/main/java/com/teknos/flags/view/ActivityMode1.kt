package com.teknos.flags.view

import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.Button
import android.widget.TextView
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.teknos.flags.R
import com.teknos.flags.data.SetQuestion
import com.teknos.flags.data.DataRetriever
import java.util.ArrayList
import com.teknos.flags.model.Country
import com.teknos.flags.data.AnswerChecker
import com.teknos.flags.data.MakeQuestion
import com.teknos.flags.R.drawable
import java.lang.Exception

class ActivityMode1 : AppCompatActivity() {

    private var mode: String? = null
    private var makeQuestion: MakeQuestion? = null
    private var flag: ImageView? = null
    private var choice1: Button? = null
    private var choice2: Button? = null
    private var choice3: Button? = null
    private var choice4: Button? = null
    private var right: TextView? = null
    private var wrong: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mode1)
        mode = intent.getStringExtra("MODE_TYPE")
        assignVars()
        makeQuestion = MakeQuestion(mode!!, "Game")
        SetQuestion(this, flag!!, choice1!!, choice2!!, choice3!!, choice4!!, makeQuestion!!)
        choice()
    }

    private fun next() {
        Handler(Looper.getMainLooper()).postDelayed(Runnable@{
            if (finished()) return@Runnable
            makeQuestion = MakeQuestion(mode!!, "Game")
            SetQuestion(
                this@ActivityMode1,
                flag!!,
                choice1!!,
                choice2!!,
                choice3!!,
                choice4!!,
                makeQuestion!!
            )
        }, 1000)
    }

    private fun assignVars() {
        val dataRetriever = DataRetriever(this, mode!!)
        data = dataRetriever.data
        fullData = ArrayList()
        (fullData as ArrayList<Country>).addAll(data!!)
        flag = findViewById(R.id.FlagImage)
        choice1 = findViewById(R.id.c1)
        choice2 = findViewById(R.id.c2)
        choice3 = findViewById(R.id.c3)
        choice4 = findViewById(R.id.c4)
        right = findViewById(R.id.rightCount)
        wrong = findViewById(R.id.wrongCount)
    }

    private fun choice(){
        choice1?.setOnClickListener {
            AnswerChecker(this, choice1, choice2, choice3, choice4, makeQuestion!!, 0, right!!, wrong!!)
            next()
        }
        choice2?.setOnClickListener {
            AnswerChecker(this, choice1, choice2, choice3, choice4, makeQuestion!!, 1, right!!, wrong!!)
            next()
        }
        choice3?.setOnClickListener {
            AnswerChecker(this, choice1, choice2, choice3, choice4, makeQuestion!!, 2, right!!, wrong!!)
            next()
        }
        choice4?.setOnClickListener {
            AnswerChecker(this, choice1, choice2, choice3, choice4, makeQuestion!!, 3, right!!, wrong!!)
            next()
        }
    }

    private fun finished(): Boolean {
        if (data?.isEmpty()!!) {
            return true
        }
        return false
    }

    companion object {
        var data: List<Country>? = null
        var fullData: MutableList<Country>? = null
        fun getResId(resName: String?): Int {
            return try {
                val idField = drawable::class.java.getDeclaredField(resName.toString())
                idField.getInt(idField)
            } catch (e: Exception) {
                e.printStackTrace()
                -1
            }
        }
    }
}