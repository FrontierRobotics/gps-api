package net.pathfinder.gps


class Speed private constructor (val metersPerSecond: Double) {

    companion object {
        fun fromKnots(knots: Double): Speed {
            return fromKilometerPerHour(knots * 1.852) //exact
        }

        fun fromMilesPerHour(mph: Double): Speed {
            return fromKilometerPerHour(mph * 1.609344) //exact
        }

        fun fromMetersPerSecond(mps: Double): Speed {
            return Speed(mps) //exact
        }

        fun fromKilometerPerHour(kph: Double): Speed {
            return Speed(kph * 0.277778)
        }
    }
}