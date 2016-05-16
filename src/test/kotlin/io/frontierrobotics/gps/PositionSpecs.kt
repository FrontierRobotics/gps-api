package io.frontierrobotics.gps

import io.frontierrobotics.gps.Direction.NORTH
import io.frontierrobotics.gps.Direction.WEST
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.shouldEqual


class PositionSpecs : Spek() {
    init {
        given("a position")
        {
            val position = Position(Angle(NORTH, 41, 10.1833), Angle(WEST, 104, 49.5843))

            on("calling toGmaps")
            {
                val gmaps = position.toGmaps()
                it("should return the correct result")
                {
                    shouldEqual("41.16972166670693,-104.826404999627", gmaps)
                }
            }
        }
    }
}