
package io.github.andrewfitzy.day18

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask02 {
    @Test fun testSolveWithDemoData_01() {
        // Given
        val fileContent = listOf("..^^.")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve(3)

        // Then
        assertEquals(6, result)
    }

    @Test fun testSolveWithDemoData_02() {
        // Given
        val fileContent = listOf(".^^.^.^^^^")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve(10)

        // Then
        assertEquals(38, result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("18")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve(400000)

        // Then
        assertEquals(19991126, result)
    }
}
