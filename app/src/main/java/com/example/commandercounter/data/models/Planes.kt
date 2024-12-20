package com.example.commandercounter.data.models

class Planes(
    val allPlanes: List<Plane>
) {
    var currentPlane: Plane
    var planesDeck: MutableList<Plane>

    init {
        planesDeck = allPlanes.shuffled().toMutableList()
        currentPlane = planesDeck.removeAt(0)
    }

    fun changePlane() {
        currentPlane = planesDeck.removeAt(0)
    }

    fun reshuffle() {
        planesDeck = allPlanes.shuffled().toMutableList()
    }

}