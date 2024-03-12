
package io.github.andrewfitzy.day20

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask01 {
    @Test fun testSolveWithDemoData_01() {
        // Given
        val fileContent =
            listOf(
                "5-8",
                "0-2",
                "4-7",
            )
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(3L, result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("20")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(22887907, result)
    }
}
