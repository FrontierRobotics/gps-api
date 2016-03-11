package net.pathfinder.gps


class Location(val latitude: Angle, val longitude: Angle) {
    fun toGmaps(): String {
        return "${latitude.toDecimal()},${longitude.toDecimal()}"
    }
}