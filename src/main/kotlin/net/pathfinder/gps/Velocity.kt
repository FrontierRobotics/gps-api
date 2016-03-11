package net.pathfinder.gps


class Velocity(kilometersPerHour: Double) {

    companion object {
        fun fromKnots(knots: Double): Velocity {
            return Velocity(knots * 1.852) //exact
        }

        fun fromMilesPerHour(mph: Double): Velocity {
            return Velocity(mph * 1.609344) //exact
        }

        fun fromMetersPerSecond(mps: Double): Velocity {
            return Velocity(mps * 3.6) //exact
        }
    }
}