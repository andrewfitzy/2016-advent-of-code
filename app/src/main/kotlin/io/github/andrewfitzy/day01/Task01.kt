package io.github.andrewfitzy.day01

import io.github.andrewfitzy.util.Point

class Task01(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    private val rotationMapping: Map<Pair<String, String>, String> =
        mapOf(
            Pair("N", "R") to "E",
            Pair("N", "L") to "W",
            Pair("E", "R") to "S",
            Pair("E", "L") to "N",
            Pair("S", "R") to "W",
            Pair("S", "L") to "E",
            Pair("W", "R") to "N",
            Pair("W", "L") to "S",
        )

    fun solve(): Int {
        var heading = "N"
        val start = Point(0, 0)
        var end = Point(0, 0)
        val moves = input.first().split(", ")
        for (move: String in moves) {
            val direction: String = move.substring(0, 1)
            val distance: Int = move.substring(1).trim().toInt()
            heading = rotationMapping[Pair(heading, direction)]!!
            end = move(end, heading, distance)
        }

        return start.getManhattanDistance(end)
    }

    private fun move(
        end: Point,
        heading: String,
        distance: Int,
    ): Point {
        return when (heading) {
            "N" -> Point(end.x, end.y + distance)
            "E" -> Point(end.x + distance, end.y)
            "S" -> Point(end.x, end.y - distance)
            else -> Point(end.x - distance, end.y) // assume W
        }
    }
}
