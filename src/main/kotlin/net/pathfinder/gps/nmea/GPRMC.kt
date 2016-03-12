package net.pathfinder.gps.nmea

import net.pathfinder.gps.Angle
import net.pathfinder.gps.Direction.*
import net.pathfinder.gps.Position
import net.pathfinder.gps.Speed
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

class GPRMC(val fixAcquired: Boolean, val dateTime: LocalDateTime, val speed: Speed, val position: Position?) {

    companion object {
        fun from(sentence: String): GPRMC {
            val parts = sentence.split(",")
            val fixAcquired = parts[2] == "A"
            val dateTime = dateTimeFromSentence(date = parts[9], time = parts[1])
            val velocity = velocityFromSentence(parts[7])
            val location = locationFromSentence(latitude = parts[3],
                    latitudeDirection = parts[4],
                    longitude = parts[5],
                    longitudeDirection = parts[6])

            return GPRMC(fixAcquired, dateTime, velocity, location)
        }

        private fun dateTimeFromSentence(date: String, time: String): LocalDateTime {
            return dateFromSentence(date).atTime(timeFromSentence(time))
        }

        private fun dateFromSentence(date: String): LocalDate {
            val dayOfMonth = date.substring(0, 2).toInt()
            val month = date.substring(2, 4).toInt()
            val year = 2000 + date.substring(4, 6).toInt()

            return LocalDate.of(year, month, dayOfMonth)
        }

        private fun timeFromSentence(time: String): LocalTime {
            val hour = time.substring(0, 2).toInt()
            val minute = time.substring(2, 4).toInt()
            val seconds = time.substring(4, 6).toInt()
            val milliseconds = time.substring(7, time.length).toInt()

            return LocalTime.of(hour, minute, seconds, milliseconds * 1000000)
        }

        fun velocityFromSentence(knots: String): Speed {
            return Speed.fromKnots(knots.toDouble())
        }

        private fun locationFromSentence(latitude: String,
                                         latitudeDirection: String,
                                         longitude: String,
                                         longitudeDirection: String): Position? {
            if (latitude.isEmpty() || latitudeDirection.isEmpty() || longitude.isEmpty() || longitudeDirection.isEmpty()) {
                return null
            }

            val latitudeAngle = angleFromSentence(latitude, latitudeDirection, degreeSize = 2)
            val longitudeAngle = angleFromSentence(longitude, longitudeDirection, degreeSize = 3)

            return Position(latitudeAngle, longitudeAngle)
        }

        private fun angleFromSentence(degreesAndMinutes: String, direction: String, degreeSize: Int): Angle {
            val degrees = degreesAndMinutes.substring(0, degreeSize).toInt()
            val minutes = degreesAndMinutes.substring(degreeSize, degreesAndMinutes.length).toDouble()

            return when (direction) {
                "N" -> Angle(NORTH, degrees, minutes)
                "E" -> Angle(EAST, degrees, minutes)
                "S" -> Angle(SOUTH, degrees, minutes)
                "W" -> Angle(WEST, degrees, minutes)
                else -> {
                    // Best thing to do?
                    return Angle(NORTH, degrees, minutes)
                }
            }
        }
    }

    constructor(other: GPRMC) : this(other.fixAcquired, other.dateTime, other.speed, other.position)

    constructor(sentence: String) : this(from(sentence))
}