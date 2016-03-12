package net.pathfinder.gps

import org.jetbrains.spek.api.Spek

class VelocitySpec : Spek() {
    init {
        val velocity = Velocity.fromKnots(1.0)
    }
}
