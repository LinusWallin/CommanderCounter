package com.example.commandercounter.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.commandercounter.data.models.Game
import com.example.commandercounter.data.models.Planes
import com.example.commandercounter.data.models.Player
import com.example.commandercounter.utils.readPlanes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GameViewModel(application: Application) : AndroidViewModel(application) {
    private val _game = MutableStateFlow(Game(
        playerCount = 2,
        playetStartLife = 40,
        playerList = emptyList()
    ))
    private val _planes = MutableStateFlow(Planes(
        readPlanes(getApplication())
    ))
    private val _planeChase = MutableStateFlow(false)
    private val _menu = MutableStateFlow(false)

    val game: StateFlow<Game> = _game
    val planes: StateFlow<Planes> = _planes
    val planeChase: StateFlow<Boolean> = _planeChase
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

    fun togglePlaneChase() {
        _planeChase.value = !_planeChase.value
    }

    fun nextPlane() {
        _planes.value.changePlane()
    }
}