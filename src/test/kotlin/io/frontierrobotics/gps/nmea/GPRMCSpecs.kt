package io.frontierrobotics.gps.nmea

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.on
import kotlin.test.assertFalse

class GPRMCSpecs : Spek({
    describe("a void sentence")
    {
        val gprmc = GPRMC("\$GPRMC,215952.087,V,,,,,0.00,0.00,070180,,,N*44")

        on("calling fixAcquired")
        {
            it("should return false")
            {
                assertFalse(gprmc.fixAcquired)
            }
        }
    }
})