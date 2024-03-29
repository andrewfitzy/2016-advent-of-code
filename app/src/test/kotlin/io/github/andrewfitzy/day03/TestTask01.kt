
package io.github.andrewfitzy.day03

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask01 {
    @Test fun testSolveWithDemoData_01() {
        // Given
        val fileContent =
            listOf(
                "5    10   25",
                "785  516  744",
            )
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(1, result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("03")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(862, result)
    }
}
