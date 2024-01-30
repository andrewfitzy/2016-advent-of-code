package io.github.andrewfitzy.util

data class Point(val x: Int, val y: Int) {
    fun getManhattanDistance(other: Point): Int {
        return Math.abs(other.x - this.x) + Math.abs(other.y - this.y)
    }
}
