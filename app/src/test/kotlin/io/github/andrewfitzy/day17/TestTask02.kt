
package io.github.andrewfitzy.day17

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask02 {
    @Test fun testSolveWithDemoData_00() {
        // Given
        val fileContent = listOf("hijkl")
        val classUnderTest = Task02(fileContent)

        // When
        var result = classUnderTest.solve()

        // Then
        assertEquals(0, result)
    }

    @Test fun testSolveWithDemoData_01() {
        // Given
        val fileContent = listOf("ihgpwlah")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(370, result)
    }

    @Test fun testSolveWithDemoData_02() {
        // Given
        val fileContent = listOf("kglvqrro")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(492, result)
    }

    @Test fun testSolveWithDemoData_03() {
        // Given
        val fileContent = listOf("ulqzkmiv")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(830, result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("17")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(386, result)
    }
}
