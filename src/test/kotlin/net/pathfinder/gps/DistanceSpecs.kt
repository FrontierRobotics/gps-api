package net.pathfinder.gps

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.shouldEqual

class DistanceSpecs : Spek() {
    init {
        given("a distance in meters")
        {
            val distance = Distance.ofMeters(45.3)

            on("calling toMeters")
            {
                it("should return the correct result")
                {
                    shouldEqual(45.3, distance.toMeters())
                }
            }

            on("calling toKilometers")
            {
                it("should return the correct result")
                {
                    shouldEqual(0.0453, distance.toKilometers())
                }
            }
        }

    }
}