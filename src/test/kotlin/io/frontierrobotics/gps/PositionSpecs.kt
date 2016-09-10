package io.frontierrobotics.gps

import io.frontierrobotics.gps.Direction.NORTH
import io.frontierrobotics.gps.Direction.WEST
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertEquals


class PositionSpecs : Spek({
    describe("a position")
    {
        val position = Position(Angle(NORTH, 41, 10.1833), Angle(WEST, 104, 49.5843))

        on("calling toGmaps")
        {
            val gmaps = position.toGmaps()
            it("should return the correct result")
            {
                assertEquals("41.16972166670693,-104.826404999627", gmaps)
            }
        }
    }
})