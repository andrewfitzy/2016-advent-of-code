
package io.github.andrewfitzy.day07

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask01 {
    @Test fun testSolveWithDemoData_01() {
        // Given
        val fileContent = listOf("abba[mnop]qrst")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(1, result)
    }

    @Test fun testSolveWithDemoData_02() {
        // Given
        val fileContent = listOf("abcd[bddb]xyyx")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(0, result)
    }

    @Test fun testSolveWithDemoData_03() {
        // Given
        val fileContent = listOf("aaaa[qwer]tyui")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(0, result)
    }

    @Test fun testSolveWithDemoData_04() {
        // Given
        val fileContent = listOf("ioxxoj[asdfgh]zxcvbn")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(1, result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("07")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(110, result)
    }
}
