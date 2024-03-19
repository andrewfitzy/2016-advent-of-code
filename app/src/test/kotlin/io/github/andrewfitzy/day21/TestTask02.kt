
package io.github.andrewfitzy.day21

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask02 {
    @Test
    fun testSolveWithDemoData_01() {
        // Given
        val fileContent =
            listOf(
                "swap position 4 with position 0",
                "swap letter d with letter b",
                "reverse positions 0 through 4",
                "rotate left 1 step",
                "move position 1 to position 4",
                "move position 3 to position 0",
                "rotate based on position of letter b",
                "rotate based on position of letter d",
            )
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve("decab")

        // Then
        assertEquals("abcde", result)
    }

    @Test
    fun testSwapPosition() {
        // Given
        val fileContent = listOf("")
        val classUnderTest = Task02(fileContent)
        val currentValue = "abcde".toMutableList()

        // When
        val result = classUnderTest.swapPosition(currentValue, 4, 0)

        // Then
        assertEquals("ebcda".toMutableList(), result)
    }

    @Test
    fun testSwapLetter() {
        // Given
        val fileContent = listOf("")
        val classUnderTest = Task02(fileContent)
        val currentValue = "ebcda".toMutableList()

        // When
        val result = classUnderTest.swapLetter(currentValue, 'd', 'b')

        // Then
        assertEquals("edcba".toMutableList(), result)
    }

    @Test
    fun testRotateDirection() {
        // Given
        val fileContent = listOf("")
        val classUnderTest = Task02(fileContent)
        val currentValue = "abcde".toMutableList()

        // When
        val result = classUnderTest.rotateDirection(currentValue, "left", 1)

        // Then
        assertEquals("bcdea".toMutableList(), result)
    }

    @Test
    fun testRotatePosition_01() {
        // Given
        val fileContent = listOf("")
        val classUnderTest = Task02(fileContent)
        val currentValue = "abdec".toMutableList()

        // When
        val result = classUnderTest.rotatePosition(currentValue, 'b')

        // Then
        assertEquals("ecabd".toMutableList(), result)
    }

    @Test
    fun testRotatePosition_02() {
        // Given
        val fileContent = listOf("")
        val classUnderTest = Task02(fileContent)
        val currentValue = "ecabd".toMutableList()

        // When
        val result = classUnderTest.rotatePosition(currentValue, 'd')

        // Then
        assertEquals("decab".toMutableList(), result)
    }

    @Test
    fun testReverse() {
        // Given
        val fileContent = listOf("")
        val classUnderTest = Task02(fileContent)
        val currentValue = "edcba".toMutableList()

        // When
        val result = classUnderTest.reverse(currentValue, 0, 4)

        // Then
        assertEquals("abcde".toMutableList(), result)
    }

    @Test
    fun testMove_01() {
        // Given
        val fileContent = listOf("")
        val classUnderTest = Task02(fileContent)
        val currentValue = "bcdea".toMutableList()

        // When
        val result = classUnderTest.move(currentValue, 1, 4)

        // Then
        assertEquals("bdeac".toMutableList(), result)
    }

    @Test
    fun testMove_02() {
        // Given
        val fileContent = listOf("")
        val classUnderTest = Task02(fileContent)
        val currentValue = "bdeac".toMutableList()

        // When
        val result = classUnderTest.move(currentValue, 3, 0)

        // Then
        assertEquals("abdec".toMutableList(), result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("21")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve("fbgdceah")

        // Then
        assertEquals("cegdahbf", result)
    }
}
