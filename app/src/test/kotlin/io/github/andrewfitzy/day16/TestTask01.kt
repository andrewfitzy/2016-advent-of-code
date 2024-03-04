
package io.github.andrewfitzy.day16

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask01 {
    @Test fun testSolveWithDemoData_01() {
        // Given
        val fileContent = listOf("10000")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve(20)

        // Then
        assertEquals("01100", result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("16")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve(272)

        // Then
        assertEquals("10010100110011100", result)
    }
}
