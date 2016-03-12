package net.pathfinder.gps


class Velocity private constructor (val metersPerSecond: Double) {

    companion object {
        fun fromKnots(knots: Double): Velocity {
            return fromKilometerPerHour(knots * 1.852) //exact
        }

        fun fromMilesPerHour(mph: Double): Velocity {
            return fromKilometerPerHour(mph * 1.609344) //exact
        }

        fun fromMetersPerSecond(mps: Double): Velocity {
            return Velocity(mps) //exact
        }

        fun fromKilometerPerHour(kph: Double): Velocity {
            return Velocity(kph * 0.277778)
        }
    }
}