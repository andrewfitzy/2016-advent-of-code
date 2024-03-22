package io.github.andrewfitzy.util

import kotlin.math.abs

data class Point(val x: Int, val y: Int) {
    fun getManhattanDistance(other: Point): Int {
        return abs(other.x - this.x) + abs(other.y - this.y)
    }

    fun isInBounds(
        startX: Int,
        startY: Int,
        endX: Int,
        endY: Int,
    ): Boolean {
        return this.x >= startX && this.y >= startY && this.x <= endX && this.y <= endY
    }
}
