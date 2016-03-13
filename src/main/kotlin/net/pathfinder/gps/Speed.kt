package net.pathfinder.gps

import java.time.Duration


class Speed (val distance: Distance, val duration: Duration) {

    companion object {
        fun ofMetersPerSecond(mps: Double): Speed = Speed(Distance.ofMeters(mps), Duration.ofSeconds(1))

        fun ofKilometersPerHour(kph: Double): Speed = ofMetersPerSecond(kph * 0.277778)

        fun ofMilesPerHour(mph: Double): Speed = ofMetersPerSecond(mph * 0.44704)

        fun ofKnots(knots: Double): Speed = ofKilometersPerHour(knots * 1.852)
    }

    fun toMetersPerSecond(): Double = distance.toMeters() / duration.seconds

    fun toKilometersPerHour(): Double = toMetersPerSecond() * 3.6

    fun toMilesPerHour(): Double = toMetersPerSecond() * 2.236936

    fun toKnots(): Double = toMetersPerSecond() * 1.943844
}