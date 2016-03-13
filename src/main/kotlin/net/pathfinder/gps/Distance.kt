package net.pathfinder.gps

class Distance private constructor(val meters: Double) {

    companion object {
        fun ofMeters(meters: Double) = Distance(meters)
    }

    fun toMeters() = meters
}