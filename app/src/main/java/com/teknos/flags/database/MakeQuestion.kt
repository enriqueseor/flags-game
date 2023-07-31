package com.teknos.flags.database

import com.teknos.flags.ActivityGame
import com.teknos.flags.ActivityOppositeGame
import java.util.*

class MakeQuestion(mode: String, Activity: String) {
    private val wrongChoices = IntArray(3)
    private val mode: String
    val choices = arrayOfNulls<String>(4)
    val rightAnsPlace: Int
    var imageName: String? = null
    var countryNum = 0

    fun normalMode() {
        choices[rightAnsPlace] = if (mode == "FtoCo") ActivityGame.data?.get(countryNum)?.countryName else ActivityGame.data?.get(countryNum)?.capitalName
        imageName = ActivityGame.data?.get(countryNum)?.imageName
        var j = 0
        for (i in 0..3) {
            if (choices[i] == null) {
                choices[i] = if (mode == "FtoCo") ActivityGame.fullData?.get(wrongChoices[j])?.countryName else ActivityGame.fullData?.get(wrongChoices[j])?.capitalName
                j++
            }
        }
    }

    fun oppositeMode() {
        imageName = if (mode == "CotoF") ActivityOppositeGame.data?.get(countryNum)?.countryName else ActivityOppositeGame.data?.get(countryNum)?.capitalName
        choices[rightAnsPlace] = ActivityOppositeGame.data?.get(countryNum)?.imageName
        var j = 0
        for (i in 0..3) {
            if (choices[i] == null) {
                choices[i] = ActivityOppositeGame.fullData?.get(wrongChoices[j])?.imageName
                j++
            }
        }
    }

    private fun getRandomChoice(choice2: Int, choice3: Int, size: Int, id: Int): Int {
        val random = Random()
        var choice1: Int
        do {
            choice1 = random.nextInt(size)
        } while (choice1 == choice2 || choice1 == choice3 || choice1 == id)
        return choice1
    }

    init {
        val random = Random()
        this.mode = mode
        val id: Int
        val size: Int
        if (Activity == "Game") {
            countryNum = random.nextInt(ActivityGame.data!!.size)
            id = ActivityGame.data?.get(countryNum)!!.id
            size = ActivityGame.fullData!!.size
        } else {
            countryNum = random.nextInt(ActivityOppositeGame.data!!.size)
            id = ActivityOppositeGame.data?.get(countryNum)!!.id
            size = ActivityOppositeGame.fullData!!.size
        }
        rightAnsPlace = random.nextInt(4)
        wrongChoices[0] = getRandomChoice(wrongChoices[1], wrongChoices[2], size, id)
        wrongChoices[1] = getRandomChoice(wrongChoices[0], wrongChoices[2], size, id)
        wrongChoices[2] = getRandomChoice(wrongChoices[0], wrongChoices[1], size, id)
    }
}