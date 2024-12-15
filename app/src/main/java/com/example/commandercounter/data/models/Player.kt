package com.example.commandercounter.data.models

data class Player(
    val name: Int,
    var lifeTotal: Int
) {
    fun increasePlayerLife(amt: Int) {
        lifeTotal += amt
    }

    fun decreasePlayerLife(amt: Int) {
        lifeTotal -= amt
    }
}