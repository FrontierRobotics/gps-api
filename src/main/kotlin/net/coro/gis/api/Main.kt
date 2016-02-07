package net.coro.gis.api

import com.fazecast.jSerialComm.SerialPort

fun main(args: Array<String>) {

    println("Hello, World!")

    val comPort = SerialPort.getCommPort("/dev/ttyAMA0")
    comPort.openPort()

    println("Baud Rate: " + comPort.getBaudRate())

    try {
        while (true) {
            while (comPort.bytesAvailable() == 0) {
                Thread.sleep(20);
            }

            val bytesAvailable : Int = comPort.bytesAvailable()

            println("Bytes Available: " + bytesAvailable)

            val readBuffer: ByteArray = ByteArray(bytesAvailable)
            val numRead = comPort.readBytes(readBuffer, bytesAvailable.toLong())
            println("Read " + numRead + " bytes: " + String(readBuffer))
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }

    comPort.closePort()
}
