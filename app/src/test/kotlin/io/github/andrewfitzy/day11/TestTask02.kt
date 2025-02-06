
package io.github.andrewfitzy.day11

import getFileContentForDay
import java.lang.IllegalStateException
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class TestTask02 {
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
        val classUnderTest = Task02(fileContent)

        // When
        var result = -1
        var exception: IllegalStateException? = null
        try {
            result = classUnderTest.solve() // this is no longer possible to solvewith task 2
        } catch (e: IllegalStateException) {
            exception = e
        }

        // Then
        assertEquals(-1, result)
        assertNotNull(exception)
    }

    @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("11")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(71, result)
    }
}
