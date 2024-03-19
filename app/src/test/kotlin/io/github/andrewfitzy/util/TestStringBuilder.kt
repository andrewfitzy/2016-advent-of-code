package io.github.andrewfitzy.util

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestStringBuilder {
    @Test
    fun testAppendAll_withOneChar() {
        // Given
        val builder = StringBuilder()

        // When
        builder.appendAll('a')

        // Then
        assertEquals("a", builder.toString())
    }

    @Test
    fun testAppendAll_withManyChar() {
        // Given
        val builder = StringBuilder()

        // When
        builder.appendAll('a', 'b', 'c')

        // Then
        assertEquals("abc", builder.toString())
    }
}
