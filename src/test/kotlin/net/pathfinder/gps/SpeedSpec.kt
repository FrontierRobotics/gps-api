package net.pathfinder.gps

import org.jetbrains.spek.api.Spek

class SpeedSpec : Spek() {
    init {
        val speed = Speed.fromKnots(1.0)
    }
}
