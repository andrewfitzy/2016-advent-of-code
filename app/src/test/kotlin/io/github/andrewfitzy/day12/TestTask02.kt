
package io.github.andrewfitzy.day12

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask02 {
    @Test fun testSolveWithDemoDate_01() {
        // Given
        val fileContent =
            listOf(
                "cpy 41 a",
                "inc a",
                "inc a",
                "dec a",
                "jnz a 2",
                "dec a",
            )
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(42, result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("12")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(9227771, result)
    }
}
