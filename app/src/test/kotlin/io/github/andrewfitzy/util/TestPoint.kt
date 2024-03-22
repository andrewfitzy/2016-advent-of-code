package io.github.andrewfitzy.util

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

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

    @Test
    fun testIsInBounds() {
        // Given
        val point = Point(1, 1)

        // When
        val result = point.isInBounds(0, 0, 2, 2)

        // Then
        assertTrue(result)
    }

    @Test
    fun testIsInBounds_leftOfBounds() {
        // Given
        val point = Point(0, 1)

        // When
        val result = point.isInBounds(1, 1, 3, 3)

        // Then
        assertFalse(result)
    }

    @Test
    fun testIsInBounds_rightOfBounds() {
        // Given
        val point = Point(4, 1)

        // When
        val result = point.isInBounds(1, 1, 3, 3)

        // Then
        assertFalse(result)
    }

    @Test
    fun testIsInBounds_aboveBounds() {
        // Given
        val point = Point(1, 0)

        // When
        val result = point.isInBounds(1, 1, 3, 3)

        // Then
        assertFalse(result)
    }

    @Test
    fun testIsInBounds_belowBounds() {
        // Given
        val point = Point(1, 4)

        // When
        val result = point.isInBounds(1, 1, 3, 3)

        // Then
        assertFalse(result)
    }
}
