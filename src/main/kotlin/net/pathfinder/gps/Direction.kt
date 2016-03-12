package net.pathfinder.gps

enum class Direction(val reverseAngle: Boolean) {
    NORTH(false), EAST(false), SOUTH(true), WEST(true)
}