
package io.github.andrewfitzy.day04

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask01 {
    @Test fun testSolveWithDemoData_01() {
        // Given
        val fileContent = listOf("aaaaa-bbb-z-y-x-123[abxyz]")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(123, result)
    }

    @Test fun testSolveWithDemoData_02() {
        // Given
        val fileContent = listOf("a-b-c-d-e-f-g-h-987[abcde]")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(987, result)
    }

    @Test fun testSolveWithDemoData_03() {
        // Given
        val fileContent = listOf("not-a-real-room-404[oarel]")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(404, result)
    }

    @Test fun testSolveWithDemoData_04() {
        // Given
        val fileContent = listOf("totally-real-room-200[decoy]")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(0, result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("04")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(361724, result)
    }
}
