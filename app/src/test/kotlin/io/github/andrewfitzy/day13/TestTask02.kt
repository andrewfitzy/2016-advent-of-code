
package io.github.andrewfitzy.day13

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask02 {
    @Test fun testSolveWithDemoData_01() {
        // Given
        val fileContent = listOf("10")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve(10)

        // Then
        assertEquals(18, result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("13")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve(50)

        // Then
        assertEquals(138, result)
    }
}
