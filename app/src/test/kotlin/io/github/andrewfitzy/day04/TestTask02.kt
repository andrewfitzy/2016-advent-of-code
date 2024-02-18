
package io.github.andrewfitzy.day04

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask02 {
    @Test fun testSolveWithDemoData_01() {
        // Given
        val fileContent = listOf("qzmt-zixmtkozy-ivhz-343[zimth]")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve("very encrypted name")

        // Then
        assertEquals(343, result)
    }

    @Test fun testSolveWithDemoData_02() {
        // Given
        val fileContent = listOf("qzmt-zixmtkozy-ivhz-343[zimth]")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve("a room never found")

        // Then
        assertEquals(0, result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("04")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve("northpole object storage")

        // Then
        assertEquals(482, result)
    }
}
