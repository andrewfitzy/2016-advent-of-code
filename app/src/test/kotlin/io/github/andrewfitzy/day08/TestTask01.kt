
package io.github.andrewfitzy.day08

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask01 {
    @Test fun testSolveWithDemoDate_01() {
        // Given
        val fileContent =
            listOf(
                "rect 3x2",
                "rotate column x=1 by 1",
                "rotate row y=0 by 4",
                "rotate column x=1 by 1",
            )
        val classUnderTest = Task01(3, 7, fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(6, result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("08")
        val classUnderTest = Task01(6, 50, fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals(128, result)
    }
}