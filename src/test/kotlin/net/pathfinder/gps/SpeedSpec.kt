package net.pathfinder.gps

import org.jetbrains.spek.api.It
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.shouldEqual
import kotlin.test.assertTrue

public fun <T : Number> It.shouldBeBetween(expectedFloor: T, expectedCeiling: T, actual: T): Unit {
    val floor = expectedFloor.toDouble()
    val ceiling = expectedCeiling.toDouble()
    val test = actual.toDouble()

    return assertTrue(((floor <= test) && (test <= ceiling)), "$actual is not between $expectedFloor and $expectedCeiling.")

}

class SpeedSpec : Spek() {
    init {
        given("a speed in meters per second")
        {
            val speed = Speed.fromMetersPerSecond(98.5)

            on("calling toKilometersPerHour")
            {
                val kilometersPerHour = speed.toKilometersPerHour()
                it("should return the correct result")
                {
                    shouldEqual(354.6, kilometersPerHour)
                }
            }

            on("calling toMilesPerHour")
            {
                val kilometersPerHour = speed.toMilesPerHour()
                it("should return the correct result")
                {
                    shouldBeBetween(220.3381, 220.3382, kilometersPerHour)
                }
            }

            on("calling toKnots")
            {
                val knots = speed.toKnots()
                it("should return the correct result")
                {
                    shouldBeBetween(191.46863, 191.4687, knots)
                }
            }
        }

        given("a speed in miles per hour")
        {
            val speed = Speed.fromMilesPerHour(65.0)

            on("calling toMetersPerSecond")
            {
                val metersPerSecond = speed.toMetersPerSecond()
                it("should return the correct result")
                {
                    shouldEqual(29.0576, metersPerSecond)
                }
            }

            on("calling toKilometersPerHour")
            {
                val kilometersPerHour = speed.toKilometersPerHour()
                it("should return the correct result")
                {
                    shouldBeBetween(104.607, 104.6074, kilometersPerHour)
                }
            }
        }

        given("a speed in knots")
        {
            val speed = Speed.fromKnots(17.0)

            on("calling toMetersPerSecond")
            {
                val metersPerSecond = speed.toMetersPerSecond()
                it("should return the correct result")
                {
                    shouldBeBetween(8.74556, 8.745563, metersPerSecond)
                }
            }
        }
    }
}
