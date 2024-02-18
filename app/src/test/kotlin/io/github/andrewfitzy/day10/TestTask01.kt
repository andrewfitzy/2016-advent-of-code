
package io.github.andrewfitzy.day10

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask01 {
    @Test fun testSolveWithDemoData_01() {
        // Given
        val fileContent =
            listOf(
                "value 5 goes to bot 2",
                "bot 2 gives low to bot 1 and high to bot 0",
                "value 3 goes to bot 1",
                "bot 1 gives low to output 1 and high to bot 0",
                "bot 0 gives low to output 2 and high to output 0",
                "value 2 goes to bot 2",
            )
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve(Pair(5, 2))

        // Then
        assertEquals(2, result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("10")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve(Pair(61, 17))

        // Then
        assertEquals(113, result)
    }
}
