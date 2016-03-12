package net.pathfinder.gps

import com.fazecast.jSerialComm.SerialPort
import net.pathfinder.gps.nmea.GPRMC
import java.io.Closeable

class SerialReader(portDescriptor: String) : Closeable {

    val serialPort = SerialPort.getCommPort(portDescriptor)

    init {
        serialPort.openPort()
    }

    override fun close() {
        serialPort.closePort()
    }

    fun readSentence(): GPRMC {
        while (serialPort.bytesAvailable() == 0) {
            Thread.sleep(20);
        }

        val bytesAvailable: Int = serialPort.bytesAvailable()

        println("Bytes Available: " + bytesAvailable)

        val readBuffer = ByteArray(bytesAvailable)
        val numRead = serialPort.readBytes(readBuffer, bytesAvailable.toLong())

        println("Bytes Read: " + numRead)

        val sentence = String(readBuffer)

        return GPRMC(sentence)
    }

    override fun toString(): String {
        return "${serialPort.baudRate} baud"
    }
}