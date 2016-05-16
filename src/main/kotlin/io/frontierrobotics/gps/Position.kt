package io.frontierrobotics.gps


class Position(val latitude: Angle, val longitude: Angle) {
    fun toGmaps(): String {
        return "${latitude.toDecimal()},${longitude.toDecimal()}"
    }
}