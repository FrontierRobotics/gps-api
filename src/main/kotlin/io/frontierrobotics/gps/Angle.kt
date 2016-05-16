package io.frontierrobotics.gps

class Angle(val direction: Direction, val degrees: Int, val minutes: Int, val seconds: Float) {

    companion object {
        fun from(direction: Direction, degrees: Double): Angle {
            val wholeDegrees = degrees.toInt()
            val minutes = (degrees - wholeDegrees) * 60
            return from(direction, wholeDegrees, minutes)
        }

        fun from(direction: Direction, degrees: Int, minutes: Double): Angle {
            val wholeMinutes = minutes.toInt()
            val seconds = (minutes - wholeMinutes) * 60
            return Angle(direction, degrees, wholeMinutes, seconds.toFloat())
        }
    }

    constructor(other: Angle) : this(other.direction, other.degrees, other.minutes, other.seconds)

    constructor(direction: Direction, degrees: Int, minutes: Double) : this(from(direction, degrees, minutes))

    constructor(direction: Direction, degrees: Double) : this(from(direction, degrees))

    fun toDecimal(): Double {
        val decimalSeconds = (seconds.toDouble() / 60) / 60
        val decimalMinutes = minutes.toDouble() / 60
        val decimalDegrees = degrees.toDouble() + decimalMinutes + decimalSeconds
        return if (direction.reverseAngle) 0 - decimalDegrees else decimalDegrees
    }
}