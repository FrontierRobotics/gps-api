package io.frontierrobotics.gps.api

import io.frontierrobotics.gps.SerialReader

fun main(args: Array<String>) {

    println("Hello, World!")

    SerialReader("/dev/ttyS0").use {
        while (true) {
            println("NMEA: " + it.readSentence())
        }
    }
}
