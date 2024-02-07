
package io.github.andrewfitzy.dayxx

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask01 {
    @Test fun testSolveWithDemoDate_01() {
        // Given
        val fileContent = listOf("")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(1, result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("xx")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(1, result)
    }
}
