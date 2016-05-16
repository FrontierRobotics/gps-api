package io.frontierrobotics.gps

import java.time.Duration


class Speed (val distance: Distance, val duration: Duration) {

    companion object {
        fun ofMetersPerSecond(mps: Double) = Speed(Distance.Companion.ofMeters(mps), Duration.ofSeconds(1))

        fun ofKilometersPerHour(kph: Double) = ofMetersPerSecond(kph * 0.277778)

        fun ofMilesPerHour(mph: Double) = ofMetersPerSecond(mph * 0.44704)

        fun ofKnots(knots: Double) = ofKilometersPerHour(knots * 1.852)
    }

    fun toMetersPerSecond() = distance.toMeters() / duration.seconds

    fun toKilometersPerHour() = toMetersPerSecond() * 3.6

    fun toMilesPerHour() = toMetersPerSecond() * 2.236936

    fun toKnots() = toMetersPerSecond() * 1.943844
}