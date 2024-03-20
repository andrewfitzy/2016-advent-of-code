
package io.github.andrewfitzy.day23

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask01 {
    @Test fun testSolveWithDemoData_01() {
        // Given
        val fileContent =
            listOf(
                "cpy 2 a",
                "tgl a",
                "tgl a",
                "tgl a",
                "cpy 1 a",
                "dec a",
                "dec a",
            )
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve(0)

        // Then
        assertEquals(3, result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("23")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve(7)

        // Then
        assertEquals(10223, result)
    }
}
