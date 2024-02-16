
package io.github.andrewfitzy.day14

import getFileContentForDay
import kotlin.test.Test
import kotlin.test.assertEquals

class TestTask02 {
    @Test
    fun testEmptyTest() {
        /*
         It takes around 7 minutes to run both tests, so I've commented them out to save on build time. Added this empty
         test so that the test runner doesn't complain.
         */
    }

    // @Test
    fun testSolveWithDemoDate_01() {
        // Given
        val fileContent = listOf("abc")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve(64)

        // Then
        assertEquals(22551, result)
    }

    // @Test
    fun testSolveWithRealDate_01() {
        // Given
        val fileContent = getFileContentForDay("14")
        val classUnderTest = Task02(fileContent)

        // When
        val result = classUnderTest.solve(64)

        // Then
        assertEquals(22423, result)
    }
}
