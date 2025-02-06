
package io.github.andrewfitzy.day11

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask01 {
    @Test
    fun testSolveWithDemoData_01() {
        // Given
        val fileContent =
            listOf(
                "The first floor contains a hydrogen-compatible microchip and a lithium-compatible microchip.",
                "The second floor contains a hydrogen generator.",
                "The third floor contains a lithium generator.",
                "The fourth floor contains nothing relevant.",
            )
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(11, result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("11")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(47, result)
    }
}
