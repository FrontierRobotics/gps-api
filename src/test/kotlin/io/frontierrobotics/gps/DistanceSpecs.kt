package io.frontierrobotics.gps

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals

class DistanceSpecs : Spek({
    describe("a distance in meters")
    {
        val distance = Distance.ofMeters(45.3)

        on("calling toMeters")
        {
            it("should return the correct result")
            {
                assertEquals(45.3, distance.toMeters())
            }
        }

        on("calling toKilometers")
        {
            it("should return the correct result")
            {
                assertEquals(0.0453, distance.toKilometers())
            }
        }
    }
})