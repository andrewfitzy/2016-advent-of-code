package io.github.andrewfitzy.util

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestPoint {
    @Test
    fun testGetManhattanDistance_withSamePoint() {
        // Given
        val start = Point(1, 1)
        val end = Point(1, 1)

        // When
        val result = start.getManhattanDistance(end)

        // Then
        assertEquals(0, result)
    }

    @Test
    fun testGetManhattanDistance_withEndOppositeStart() {
        // Given
        val start = Point(1, 1)
        val end = Point(2, 2)

        // When
        val result = start.getManhattanDistance(end)

        // Then
        assertEquals(2, result)
    }

    @Test
    fun testGetManhattanDistance_withEndAwayFromStart() {
        // Given
        val start = Point(1, 1)
        val end = Point(3, 4)

        // When
        val result = start.getManhattanDistance(end)

        // Then
        assertEquals(5, result)
    }

    @Test
    fun testGetManhattanDistance_withNegativeCoordinates() {
        // Given
        val start = Point(1, 1)
        val end = Point(-3, -4)

        // When
        val result = start.getManhattanDistance(end)

        // Then
        assertEquals(9, result)
    }
}
