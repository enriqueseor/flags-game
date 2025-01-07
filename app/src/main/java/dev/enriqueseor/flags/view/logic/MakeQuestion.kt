package dev.enriqueseor.flags.view.logic

import dev.enriqueseor.flags.view.activity.ActivityMode1
import dev.enriqueseor.flags.view.activity.ActivityMode2
import java.util.*

class MakeQuestion(mode: String, activity: String) {

    private val wrongChoices = IntArray(3)
    private val mode: String
    val choices = arrayOfNulls<String>(4)
    val rightAnsPlace: Int
    var imageName: String? = null
    private var countryNum = 0

    init {
        val random = Random()
        this.mode = mode
        val id: Int
        val size: Int
        if (activity == "Game") {
            countryNum = random.nextInt(ActivityMode1.data!!.size)
            id = ActivityMode1.data?.get(countryNum)!!.id
            size = ActivityMode1.fullData!!.size
        } else {
            countryNum = random.nextInt(ActivityMode2.data!!.size)
            id = ActivityMode2.data?.get(countryNum)!!.id
            size = ActivityMode2.fullData!!.size
        }
        rightAnsPlace = random.nextInt(4)
        wrongChoices[0] = getRandomChoice(wrongChoices[1], wrongChoices[2], size, id)
        wrongChoices[1] = getRandomChoice(wrongChoices[0], wrongChoices[2], size, id)
        wrongChoices[2] = getRandomChoice(wrongChoices[0], wrongChoices[1], size, id)
    }

    fun mode1() {
        choices[rightAnsPlace] = if (mode == "FtoCo") ActivityMode1.data?.get(countryNum)?.countryName else ActivityMode1.data?.get(countryNum)?.capitalName
        imageName = ActivityMode1.data?.get(countryNum)?.imageName
        var j = 0
        for (i in 0..3) {
            if (choices[i] == null) {
                choices[i] = if (mode == "FtoCo") ActivityMode1.fullData?.get(wrongChoices[j])?.countryName else ActivityMode1.fullData?.get(wrongChoices[j])?.capitalName
                j++
            }
        }
    }

    fun mode2() {
        imageName = if (mode == "CotoF") ActivityMode2.data?.get(countryNum)?.countryName else ActivityMode2.data?.get(countryNum)?.capitalName
        choices[rightAnsPlace] = ActivityMode2.data?.get(countryNum)?.imageName
        var j = 0
        for (i in 0..3) {
            if (choices[i] == null) {
                choices[i] = ActivityMode2.fullData?.get(wrongChoices[j])?.imageName
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
}