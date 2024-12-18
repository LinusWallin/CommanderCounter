package com.example.commandercounter.viewmodels

import androidx.lifecycle.ViewModel
import com.example.commandercounter.data.models.Game
import com.example.commandercounter.data.models.Player
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GameViewModel : ViewModel() {
    private val _game = MutableStateFlow(Game(
        playerCount = 2,
        playetStartLife = 40,
        playerList = emptyList()
    ))
    private val _menu = MutableStateFlow(false)

    val game: StateFlow<Game> = _game
    val menu: StateFlow<Boolean> = _menu

    fun setPlayerCount(count: Int) {
        _game.value = _game.value.copy(playerCount = count)
    }

    fun setPlayerStartLife(count: Int) {
        _game.value = _game.value.copy(playetStartLife = count)
    }

    fun appendPlayer(player: Player) {
        _game.value = _game.value.copy(playerList = _game.value.playerList + player)
    }

    fun toggleMenu() {
        _menu.value = !_menu.value
    }
}