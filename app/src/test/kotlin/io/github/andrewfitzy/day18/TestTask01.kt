
package io.github.andrewfitzy.day18

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask01 {
    @Test fun testSolveWithDemoDate_01() {
        // Given
        val fileContent = listOf("..^^.")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve(3)

        // Then
        assertEquals(6, result)
    }

    @Test fun testSolveWithDemoDate_02() {
        // Given
        val fileContent = listOf(".^^.^.^^^^")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve(10)

        // Then
        assertEquals(38, result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("18")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve(40)

        // Then
        assertEquals(1974, result)
    }
}
