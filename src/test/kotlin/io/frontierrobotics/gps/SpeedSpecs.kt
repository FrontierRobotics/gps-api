package io.frontierrobotics.gps

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import test.assertBetween
import kotlin.test.assertEquals

class SpeedSpecs : Spek({
    describe("a speed in meters per second")
    {
        val speed = Speed.ofMetersPerSecond(98.5)

        on("calling toKilometersPerHour")
        {
            it("should return the correct result")
            {
                assertEquals(354.6, speed.toKilometersPerHour())
            }
        }

        on("calling toMilesPerHour")
        {
            it("should return the correct result")
            {
                assertBetween(220.3381, 220.3382, speed.toMilesPerHour())
            }
        }

        on("calling toKnots")
        {
            val knots = speed.toKnots()
            it("should return the correct result")
            {
                assertBetween(191.46863, 191.4687, knots)
            }
        }
    }

    describe("a speed in miles per hour")
    {
        val speed = Speed.ofMilesPerHour(65.0)

        on("calling toMetersPerSecond")
        {
            val metersPerSecond = speed.toMetersPerSecond()
            it("should return the correct result")
            {
                assertEquals(29.0576, metersPerSecond)
            }
        }

        on("calling toKilometersPerHour")
        {
            val kilometersPerHour = speed.toKilometersPerHour()
            it("should return the correct result")
            {
                assertBetween(104.607, 104.6074, kilometersPerHour)
            }
        }
    }

    describe("a speed in knots")
    {
        val speed = Speed.ofKnots(17.0)

        on("calling toMetersPerSecond")
        {
            val metersPerSecond = speed.toMetersPerSecond()
            it("should return the correct result")
            {
                assertBetween(8.74556, 8.745563, metersPerSecond)
            }
        }
    }
})
