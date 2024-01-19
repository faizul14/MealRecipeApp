package com.faezolmp.mealrecipeapp.core.helper

import kotlin.random.Random

object DataRandom {
    fun randomTimeForCokking(): String{
        val cookingTime = Random.nextInt(30, 60)
        return "$cookingTime mins"
    }
}