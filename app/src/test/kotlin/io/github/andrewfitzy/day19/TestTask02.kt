
package io.github.andrewfitzy.day19

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask02 {
    @Test fun testSolveWithDemoData_01() {
        // Given
        val fileContent = listOf("5")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(2, result)
    }

    @Test fun testSolveWithDemoData_02() {
        // Given
        val fileContent = listOf("10")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(1, result)
    }

    @Test fun testSolveWithDemoData_03() {
        // Given
        val fileContent = listOf("27")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(27, result)
    }

    @Test fun testSolveWithDemoData_04() {
        // Given
        val fileContent = listOf("10000")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(3439, result)
    }

    // Takes about 40mins to run, you have been warned
    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("19")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(1420064, result)
    }
}
