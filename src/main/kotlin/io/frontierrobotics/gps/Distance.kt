package io.frontierrobotics.gps

class Distance private constructor(val meters: Double) {

    companion object {
        fun ofMeters(meters: Double) = Distance(meters)
    }

    fun toMeters() = meters

    fun toKilometers() = toMeters() / 1000
}