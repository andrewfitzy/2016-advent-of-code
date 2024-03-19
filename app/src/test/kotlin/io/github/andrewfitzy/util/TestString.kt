package io.github.andrewfitzy.util

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TestString {
    @Test
    fun testMD5() {
        // Given
        val inputString = "abc"

        // When
        val result = inputString.md5()

        // Then
        assertEquals("900150983cd24fb0d6963f7d28e17f72", result)
    }

    @Test
    fun testGetPermutations() {
        // Given
        val inputString = "abc"

        // When
        val result = inputString.getPermutations()

        // Then
        assertEquals(6, result.size)
        assertTrue(result.contains("abc"))
        assertTrue(result.contains("acb"))
        assertTrue(result.contains("bac"))
        assertTrue(result.contains("bca"))
        assertTrue(result.contains("cab"))
        assertTrue(result.contains("cba"))
    }
}
