
package io.github.andrewfitzy.day25

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask01 {
    @Test fun testSolveWithDemoData_01() {
        // Given
        val fileContent =
            listOf(
                "dec a",
                "out a",
                "inc a",
                "out a",
                "jnz a -4",
                "inc a",
                "out a",
                "jnz a -7",
            )
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(1, result)
    }

    @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("25")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(189, result)
    }
}
