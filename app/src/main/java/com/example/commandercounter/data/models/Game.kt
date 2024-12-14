package com.example.commandercounter.data.models

data class Game(
    var playerCount: Int,
    var playetStartLife: Int,
    val playerList: List<Player>
) {

}