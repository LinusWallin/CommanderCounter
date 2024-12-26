package com.example.commandercounter.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.commandercounter.data.models.Game
import com.example.commandercounter.data.models.Planes
import com.example.commandercounter.data.models.Player
import com.example.commandercounter.utils.readPlanes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class GameViewModel(application: Application) : AndroidViewModel(application) {
    private val _game = MutableStateFlow(Game(
        playerCount = 2,
        playerStartLife = 40,
        playerList = emptyList()
    ))
    private val _planes = MutableStateFlow(Planes(
        readPlanes(getApplication())
    ))
    private val _planeChase = MutableStateFlow(false)
    private val _menu = MutableStateFlow(false)
    private val _screenAwake = MutableStateFlow(false)

    val game: StateFlow<Game> = _game
    val planes: StateFlow<Planes> = _planes
    val planeChase: StateFlow<Boolean> = _planeChase
    val menu: StateFlow<Boolean> = _menu
    val screenAwake: StateFlow<Boolean> = _screenAwake

    fun setPlayerCount(count: Int) {
        _game.value = _game.value.copy(playerCount = count)
    }

    fun setPlayerStartLife(count: Int) {
        _game.value = _game.value.copy(playerStartLife = count)
    }

    fun startGame(
        playerCount: Int,
        playerStartLife: Int
    ) {
        _game.update {
            currentGame ->
            val newPlayers = (1..playerCount).map { playerName ->
                Player(playerName, playerStartLife)
            }
            currentGame.copy(
                playerCount = playerCount,
                playerStartLife = playerStartLife,
                playerList = newPlayers
            )
        }
    }

    fun appendPlayer(player: Player) {
        _game.value = _game.value.copy(playerList = _game.value.playerList + player)
    }

    fun removePlayer(playerIdx: Int) {
        val updatedPlayerList = _game.value.playerList.toMutableList().apply {
            if (playerIdx in indices) {
                removeAt(playerIdx)
            }
        }
        _game.value = _game.value.copy(playerList = updatedPlayerList)
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

    fun toggleScreenAwake() {
        _screenAwake.value = !_screenAwake.value
    }
}