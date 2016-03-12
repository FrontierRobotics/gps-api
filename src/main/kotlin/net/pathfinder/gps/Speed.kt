package net.pathfinder.gps


class Speed private constructor (val metersPerSecond: Double) {

    companion object {
        fun fromMetersPerSecond(mps: Double): Speed = Speed(mps)

        fun fromKilometerPerHour(kph: Double): Speed = Speed(kph * 0.277778)

        fun fromMilesPerHour(mph: Double): Speed = fromMetersPerSecond(mph * 0.44704)

        fun fromKnots(knots: Double): Speed = fromKilometerPerHour(knots * 1.852)
    }

    /**
    exact
     */
    fun toMetersPerSecond(): Double = metersPerSecond

    fun toKilometersPerHour(): Double = toMetersPerSecond() * 3.6

    fun toMilesPerHour(): Double = toMetersPerSecond() * 2.236936

    fun toKnots(): Double = toMetersPerSecond() * 1.943844
}