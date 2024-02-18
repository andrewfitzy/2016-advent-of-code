
package io.github.andrewfitzy.day07

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask02 {
    @Test fun testSolveWithDemoData_01() {
        // Given
        val fileContent = listOf("aba[bab]xyz")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(1, result)
    }

    @Test fun testSolveWithDemoData_02() {
        // Given
        val fileContent = listOf("xyx[xyx]xyx")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(0, result)
    }

    @Test fun testSolveWithDemoData_03() {
        // Given
        val fileContent = listOf("aaa[kek]eke")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(1, result)
    }

    @Test fun testSolveWithDemoData_04() {
        // Given
        val fileContent = listOf("zazbz[bzb]cdb")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(1, result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("07")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(242, result)
    }
}
