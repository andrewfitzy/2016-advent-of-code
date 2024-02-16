
package io.github.andrewfitzy.day14

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask01 {
    @Test fun testSolveWithDemoDate_01() {
        // Given
        val fileContent = listOf("abc")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve(64)

        // Then
        assertEquals(22728, result)
    }

    @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("14")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve(64)

        // Then
        assertEquals(16106, result)
    }
}
