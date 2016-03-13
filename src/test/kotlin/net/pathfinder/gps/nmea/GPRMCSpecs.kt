package net.pathfinder.gps.nmea

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.shouldBeFalse


class GPRMCSpecs : Spek() {
    init {
        given("a void sentence")
        {
            val gprmc = GPRMC("\$GPRMC,215952.087,V,,,,,0.00,0.00,070180,,,N*44")

            on("calling fixAcquired")
            {
                it("should return false")
                {
                    shouldBeFalse(gprmc.fixAcquired)
                }
            }
        }
    }
}