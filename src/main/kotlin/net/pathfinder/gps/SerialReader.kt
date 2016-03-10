package net.pathfinder.gps

import com.fazecast.jSerialComm.SerialPort
import java.io.Closeable

class SerialReader(portDescripter: String) : Closeable {

    val serialPort = SerialPort.getCommPort(portDescripter)

    init {
        serialPort.openPort()
    }

    override fun close() {
        serialPort.closePort()
    }

    fun readSentence(): String {
        while (serialPort.bytesAvailable() == 0) {
            Thread.sleep(20);
        }

        val bytesAvailable: Int = serialPort.bytesAvailable()

        println("Bytes Available: " + bytesAvailable)

        val readBuffer = ByteArray(bytesAvailable)
        val numRead = serialPort.readBytes(readBuffer, bytesAvailable.toLong())


        return String(readBuffer)
    }

    override fun toString(): String {
        return "${serialPort.baudRate} baud"
    }
}