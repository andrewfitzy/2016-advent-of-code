
package io.github.andrewfitzy.day24

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask01 {
    @Test fun testSolveWithDemoData_01() {
        // Given
        val fileContent =
            listOf(
                "###########",
                "#0.1.....2#",
                "#.#######.#",
                "#4.......3#",
                "###########",
            )
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(14, result)
    }

    @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("24")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(502, result)
    }
}
