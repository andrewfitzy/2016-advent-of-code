
package io.github.andrewfitzy.day23

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask02 {
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
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve(0)

        // Then
        assertEquals(3, result)
    }

    // @Test //this takes about 7 minutes to run without optimization
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("23")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve(12)

        // Then
        assertEquals(479006783, result)
    }
}
