package net.pathfinder.gps.api

import net.pathfinder.gps.SerialReader

fun main(args: Array<String>) {

    println("Hello, World!")

    SerialReader("/dev/ttyAMA0").use {
        while (true) {
            println("NMEA: " + it.readSentence())
        }
    }
}
