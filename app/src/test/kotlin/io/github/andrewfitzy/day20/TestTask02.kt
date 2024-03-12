
package io.github.andrewfitzy.day20

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask02 {
    @Test fun testSolveWithDemoData_01() {
        // Given
        val fileContent =
            listOf(
                "5-8",
                "0-2",
                "4-7",
            )
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve(9L)

        // Then
        assertEquals(2L, result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("20")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve(4294967295L)

        // Then
        assertEquals(109L, result)
    }
}
