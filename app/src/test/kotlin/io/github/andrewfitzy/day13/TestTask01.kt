
package io.github.andrewfitzy.day13

import getFileContentForDay
import io.github.andrewfitzy.util.Point
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask01 {
    @Test fun testSolveWithDemoData_01() {
        // Given
        val fileContent = listOf("10")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve(Point(7, 4))

        // Then
        assertEquals(11, result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("13")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve(Point(31, 39))

        // Then
        assertEquals(82, result)
    }
}
