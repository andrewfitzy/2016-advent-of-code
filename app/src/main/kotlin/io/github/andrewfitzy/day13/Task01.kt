package io.github.andrewfitzy.day13

import io.github.andrewfitzy.util.Point

private const val WALL = '#'

private const val OPEN_SPACE = '.'

private const val MARGIN = 5

class Task01(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    private val possibleMoves = listOf(Point(-1, 0), Point(1, 0), Point(0, -1), Point(0, 1))

    fun solve(target: Point): Int {
        val favouriteNumber = input[0].toInt()
        val map = buildMap(target, favouriteNumber)

        val startPoint = Point(1, 1)

        val shortestRoute = getShortestRoute(startPoint, target, map)
        printSolution(shortestRoute, map)

        return shortestRoute.size - 1
    }

    private fun printSolution(
        shortestRoute: List<Point>,
        map: List<List<Char>>,
    ) {
        for (rowIndex in map.indices) {
            val builder = StringBuilder()
            val row = map[rowIndex]
            for (cellIndex in row.indices) {
                val cell = row[cellIndex]
                val tmpPoint = Point(cellIndex, rowIndex)
                if (shortestRoute.contains(tmpPoint)) {
                    builder.append("0")
                } else {
                    builder.append(cell)
                }
            }
            println(builder.toString())
        }
    }

    private fun getShortestRoute(
        startPoint: Point,
        targetPoint: Point,
        map: List<List<Char>>,
    ): List<Point> {
        val deque = ArrayDeque<Step>()
        val visited = mutableSetOf<Point>()
        val start = Step(startPoint, listOf(startPoint))
        deque.add(start)
        visited.add(startPoint)
        while (!deque.isEmpty()) {
            val step = deque.removeFirst()
            if (step.location == targetPoint) {
                return step.route
            }
            visited.add(step.location)

            for (move in possibleMoves) {
                val tmpPoint = Point(step.location.x + move.x, step.location.y + move.y)
                if (visited.contains(tmpPoint) || !isValidMove(tmpPoint, map)) {
                    continue
                }
                deque.add(Step(tmpPoint, step.route + listOf(tmpPoint)))
            }
        }

        throw IllegalArgumentException("Cant get to target $targetPoint")
    }

    private fun isValidMove(
        tmpPoint: Point,
        map: List<List<Char>>,
    ): Boolean {
        val isInBounds = tmpPoint.isInBounds(0, 0, map[0].lastIndex, map.lastIndex)
        return isInBounds && map[tmpPoint.y][tmpPoint.x] == OPEN_SPACE
    }

    private fun buildMap(
        target: Point,
        favouriteNumber: Int,
    ): List<List<Char>> {
        val map = mutableListOf<List<Char>>()

        for (y in 0..target.y + MARGIN) {
            val rowArray = mutableListOf<Char>()
            for (x in 0..target.x + MARGIN) {
                val cellValue = getCellValue(x, y, favouriteNumber)
                rowArray.add(cellValue)
            }
            map.add(rowArray)
        }
        return map
    }

    @Suppress("MagicNumber") // equation contains number so ignore this rule
    private fun getCellValue(
        x: Int,
        y: Int,
        favouriteNumber: Int,
    ): Char {
        var equationResult = x * x + 3 * x + 2 * x * y + y + y * y
        equationResult += favouriteNumber
        val cellValueStr = equationResult.toString(radix = 2)
        val oneCount = cellValueStr.count { it == '1' }
        var cellValue = OPEN_SPACE
        if (oneCount % 2 == 1) {
            cellValue = WALL
        }
        return cellValue
    }
}
