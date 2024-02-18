
package io.github.andrewfitzy.day01

import getFileContentForDay
import org.junit.jupiter.api.Tag
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask01 {
    @Test fun testSolveWithDemoData_01() {
        // Given
        val fileContent = listOf("R2, L3")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(5, result)
    }

    @Test fun testSolveWithDemoData_02() {
        // Given
        val fileContent = listOf("R2, R2, R2")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(2, result)
    }

    @Test fun testSolveWithDemoData_03() {
        // Given
        val fileContent = listOf("R5, L5, R5, R3")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(12, result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("01")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(230, result)
    }
}
