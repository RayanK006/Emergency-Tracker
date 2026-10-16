package org.setu.emergencytracker

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

class ServiceTest {

    @Test
    fun serviceNameTest() {
        val service = Service(
            id = 1,
            title = "Waterford Hospital",
            desc = "Hospital"
        )

        assertEquals("Waterford Hospital", service.title)
    }
}