
package io.github.andrewfitzy.day09

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask01 {
    @Test fun testSolveWithDemoData_01() {
        // Given
        val fileContent = listOf("ADVENT")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(6, result)
    }

    @Test fun testSolveWithDemoData_02() {
        // Given
        val fileContent = listOf("A(1x5)BC")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(7, result)
    }

    @Test fun testSolveWithDemoData_03() {
        // Given
        val fileContent = listOf("(3x3)XYZ")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(9, result)
    }

    @Test fun testSolveWithDemoData_04() {
        // Given
        val fileContent = listOf("A(2x2)BCD(2x2)EFG")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(11, result)
    }

    @Test fun testSolveWithDemoData_05() {
        // Given
        val fileContent = listOf("(6x1)(1x3)A")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(6, result)
    }

    @Test fun testSolveWithDemoData_06() {
        // Given
        val fileContent = listOf("X(8x2)(3x3)ABCY")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(18, result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("09")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(102239, result)
    }
}
