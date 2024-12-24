package com.example.commandercounter.data.models

data class Game(
    var playerCount: Int,
    var playerStartLife: Int,
    val playerList: List<Player>
) {

}