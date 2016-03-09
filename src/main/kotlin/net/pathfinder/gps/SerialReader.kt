package net.pathfinder.gps

import com.fazecast.jSerialComm.SerialPort

class SerialReader(val serialPort: SerialPort) {

    fun readSentence(): String {
        while (serialPort.bytesAvailable() == 0) {
            Thread.sleep(20);
        }

        val bytesAvailable : Int = serialPort.bytesAvailable()

        println("Bytes Available: " + bytesAvailable)

        val readBuffer = ByteArray(bytesAvailable)
        val numRead = serialPort.readBytes(readBuffer, bytesAvailable.toLong())


        return String(readBuffer)
    }
}