package io.github.andrewfitzy.day22

import io.github.andrewfitzy.util.Point

private const val BIG_STORAGE_THRESHOLD = 100

data class Node(val x: Int, val y: Int, val size: Int, val used: Int, val available: Int, val usedPercentage: Int) {
    fun getContent(): Char {
        val content: Char
        if (this.used > BIG_STORAGE_THRESHOLD) {
            content = '#'
        } else if (this.used == 0) {
            content = '_'
        } else {
            content = '.'
        }
        return content
    }

    fun location(): Point {
        return Point(this.x, this.y)
    }
}
