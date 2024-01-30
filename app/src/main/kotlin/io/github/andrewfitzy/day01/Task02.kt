package io.github.andrewfitzy.day01

import io.github.andrewfitzy.util.Point

class Task02(puzzleInput: List<String>) {
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
        val seen = HashSet<Point>()
        var found = false
        val moves = input.first().split(", ")
        for (move: String in moves) {
            val direction: String = move.substring(0, 1)
            val distance: Int = move.substring(1).trim().toInt()
            heading = rotationMapping[Pair(heading, direction)]!!

            val steps = steps(end, heading, distance)
            end = steps.last()
            for (step in steps) {
                if (seen.contains(step)) {
                    end = step
                    found = true
                    break
                }
                seen.add(step)
            }
            if (found) {
                break
            }
        }
        return start.getManhattanDistance(end)
    }

    private fun steps(
        end: Point,
        heading: String,
        distance: Int,
    ): List<Point> {
        return when (heading) {
            "N" -> (1..distance).map { Point(end.x, end.y + it) }
            "E" -> (1..distance).map { Point(end.x + it, end.y) }
            "S" -> (1..distance).map { Point(end.x, end.y - it) }
            "W" -> (1..distance).map { Point(end.x - it, end.y) }
            else -> emptyList()
        }
    }
}
