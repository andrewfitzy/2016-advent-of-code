
package io.github.andrewfitzy.day09

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask02 {
    @Test fun testSolveWithDemoData_01() {
        // Given
        val fileContent = listOf("(3x3)XYZ")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(9L, result)
    }

    @Test fun testSolveWithDemoData_02() {
        // Given
        val fileContent = listOf("X(8x2)(3x3)ABCY")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(20L, result)
    }

    @Test fun testSolveWithDemoData_03() {
        // Given
        val fileContent = listOf("(27x12)(20x12)(13x14)(7x10)(1x12)A")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(241920L, result)
    }

    @Test fun testSolveWithDemoData_04() {
        // Given
        val fileContent = listOf("(25x3)(3x3)ABC(2x3)XY(5x2)PQRSTX(18x9)(3x2)TWO(5x7)SEVEN")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(445L, result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("09")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(10780403063L, result)
    }
}
