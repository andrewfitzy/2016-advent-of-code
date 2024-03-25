package io.github.andrewfitzy.day17

import io.github.andrewfitzy.util.Point
import io.github.andrewfitzy.util.md5

private const val UP_INDEX = 0
private const val DOWN_INDEX = 1
private const val LEFT_INDEX = 2
private const val RIGHT_INDEX = 3

private const val SIDE_LENGTH = 4

private val OPEN_DOOR_REGEX = "[b-f]".toRegex()

class Task01(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    fun solve(): String {
        val password = input[0]
        val startPoint = Point(0, 0)
        val targetPoint = Point(SIDE_LENGTH - 1, SIDE_LENGTH - 1)

        val route = getShortestRoute(startPoint, targetPoint, password)

        return route.joinToString(separator = "")
    }

    private fun getShortestRoute(
        startPoint: Point,
        targetPoint: Point,
        password: String,
    ): List<Char> {
        val deque = ArrayDeque<Step>()
        val start = Step(startPoint, listOf())
        deque.add(start)
        while (!deque.isEmpty()) {
            val step = deque.removeFirst()
            if (step.location == targetPoint) {
                return step.route
            }

            val tmpPassword = password + step.route.joinToString(separator = "")
            val availableMoves = getAvailableMoves(step.location, tmpPassword)
            for (move in availableMoves) {
                val tmpPoint = Point(step.location.x + move.offset.x, step.location.y + move.offset.y)
                deque.add(Step(tmpPoint, step.route + listOf(move.identifier)))
            }
        }

        throw IllegalArgumentException("Cant get to target $targetPoint")
    }

    private fun getAvailableMoves(
        location: Point,
        password: String,
    ): List<Direction> {
        val md5 = password.md5()
        val availableDirections = mutableListOf<Direction>()

        val up = md5[UP_INDEX]
        val down = md5[DOWN_INDEX]
        val left = md5[LEFT_INDEX]
        val right = md5[RIGHT_INDEX]

        if (OPEN_DOOR_REGEX.matches(up.toString()) && location.y - 1 >= 0) {
            availableDirections.add(Direction.UP)
        }

        if (OPEN_DOOR_REGEX.matches(down.toString()) && location.y + 1 < SIDE_LENGTH) {
            availableDirections.add(Direction.DOWN)
        }

        if (OPEN_DOOR_REGEX.matches(left.toString()) && location.x - 1 >= 0) {
            availableDirections.add(Direction.LEFT)
        }

        if (OPEN_DOOR_REGEX.matches(right.toString()) && location.x + 1 < SIDE_LENGTH) {
            availableDirections.add(Direction.RIGHT)
        }

        return availableDirections
    }
}
