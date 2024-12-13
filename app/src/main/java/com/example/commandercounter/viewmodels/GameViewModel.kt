package com.example.commandercounter.viewmodels

import androidx.lifecycle.ViewModel
import com.example.commandercounter.data.models.Game
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GameViewModel : ViewModel() {
    private val _game = MutableStateFlow(Game(
        playerCount = 2,
        playetStartLife = 40,
        playerList = emptyList()
    ))
    val game: StateFlow<Game> = _game

    fun setPlayerCount(count: Int) {
        _game.value = _game.value.copy(playerCount = count)
    }

    fun setPlayerStartLife(count: Int) {
        _game.value = _game.value.copy(playetStartLife = count)
    }
}