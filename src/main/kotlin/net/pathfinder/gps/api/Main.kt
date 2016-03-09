package net.pathfinder.gps.api

import com.fazecast.jSerialComm.SerialPort
import net.pathfinder.gps.SerialReader

fun main(args: Array<String>) {

    println("Hello, World!")

    val comPort = SerialPort.getCommPort("/dev/ttyAMA0")
    comPort.openPort()

    val nmeaReader = SerialReader(comPort)

    println("Baud Rate: " + comPort.baudRate)

    try {
        while (true) {
            println("NMEA: " + nmeaReader.readSentence())
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }

    comPort.closePort()
}
