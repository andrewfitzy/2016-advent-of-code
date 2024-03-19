package io.github.andrewfitzy.util

import kotlin.math.abs

data class Point(val x: Int, val y: Int) {
    fun getManhattanDistance(other: Point): Int {
        return abs(other.x - this.x) + abs(other.y - this.y)
    }
}
