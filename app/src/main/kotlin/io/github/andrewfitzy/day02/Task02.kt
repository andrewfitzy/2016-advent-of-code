package io.github.andrewfitzy.day02

import io.github.andrewfitzy.util.Point

class Task02(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    private val keyPad: Array<CharArray> =
        arrayOf(
            charArrayOf('0', '0', '1', '0', '0'),
            charArrayOf('0', '2', '3', '4', '0'),
            charArrayOf('5', '6', '7', '8', '9'),
            charArrayOf('0', 'A', 'B', 'C', '0'),
            charArrayOf('0', '0', 'D', '0', '0'),
        )

    fun solve(): String {
        val codeBuilder = StringBuilder()
        var location = Point(0, 2)

        for (entry in input) {
            location = getDestinationDigit(entry, location)
            codeBuilder.append(keyPad[location.y][location.x])
        }

        return codeBuilder.toString()
    }

    private fun getDestinationDigit(
        entry: String,
        startPoint: Point,
    ): Point {
        var location = startPoint
        entry.split("").forEach { move ->
            location = getNextPosition(location, move)
        }
        return location
    }

    private fun getNextPosition(
        location: Point,
        move: Any,
    ): Point {
        return when (move) {
            "U" ->
                if (location.y > 0 && keyPad[location.x][location.y - 1] != '0') {
                    Point(location.x, location.y - 1)
                } else {
                    location
                }
            "D" ->
                if (location.y < keyPad.size - 1 && keyPad[location.x][location.y + 1] != '0') {
                    Point(
                        location.x,
                        location.y + 1,
                    )
                } else {
                    location
                }
            "L" ->
                if (location.x > 0 && keyPad[location.x - 1][location.y] != '0') {
                    Point(location.x - 1, location.y)
                } else {
                    location
                }
            "R" ->
                if (location.x < keyPad.size - 1 && keyPad[location.x + 1][location.y] != '0') {
                    Point(
                        location.x + 1,
                        location.y,
                    )
                } else {
                    location
                }
            else -> location
        }
    }
}
