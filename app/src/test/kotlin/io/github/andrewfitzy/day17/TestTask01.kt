
package io.github.andrewfitzy.day17

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class TestTask01 {
    @Test fun testSolveWithDemoData_00() {
        // Given
        val fileContent = listOf("hijkl")
        val classUnderTest = Task01(fileContent)

        // When
        var result = ""
        var exception: IllegalArgumentException? = null
        try {
            result = classUnderTest.solve()
        } catch (e: IllegalArgumentException) {
            exception = e
        }

        // Then
        assertEquals("", result)
        assertNotNull(exception)
    }

    @Test fun testSolveWithDemoData_01() {
        // Given
        val fileContent = listOf("ihgpwlah")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals("DDRRRD", result)
    }

    @Test fun testSolveWithDemoData_02() {
        // Given
        val fileContent = listOf("kglvqrro")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals("DDUDRLRRUDRD", result)
    }

    @Test fun testSolveWithDemoData_03() {
        // Given
        val fileContent = listOf("ulqzkmiv")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals("DRURDRUDDLLDLUURRDULRLDUUDDDRR", result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("17")
        val classUnderTest = Task01(fileContent)

        // When
        val result = classUnderTest.solve()

        // Then
        assertEquals("RDRDUDLRDR", result)
    }
}
