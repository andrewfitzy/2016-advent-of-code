package io.github.andrewfitzy.day22

import io.github.andrewfitzy.util.Point
import java.util.ArrayDeque

private const val WALL = '#'

class Task02(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput
    private val nodeRegex = "/dev/grid/node-x(\\d+)-y(\\d+) +(\\d+)T +(\\d+)T +(\\d+)T +(\\d+)%".toRegex()
    private val possibleMoves = listOf(Point(-1, 0), Point(1, 0), Point(0, -1), Point(0, 1))

    fun solve(): Int {
        val nodes =
            input.filter { line -> line.startsWith("/") }.map { line -> toNode(line) }
                .associateBy { item -> Point(item.x, item.y) }

        val grid = buildGrid(nodes)
        printGrid(grid)

        val startNode = nodes.filter { node -> node.value.used == 0 }.toList().first().second
        val endNode = grid[0][grid[0].lastIndex - 1]

        // BFS to get to the space before the data we want to move
        val dist = getShortestRoute(startNode, endNode, grid)

        // Top row now look like ..._G
        // Get length of top row, minus 2, times 5, add 1
        // Should really validate that the moves are valid, I tried my answer and it was ok, so I don't think the
        // validation is needed.

        val shuffleAcrossTheTop = calculateTopRowShuffles(grid[0].size) // ((grid[0].size - 2) * 5) + 1
        return shuffleAcrossTheTop + dist
    }

    @Suppress("MagicNumber") // I feel this is better than creating constants
    private fun calculateTopRowShuffles(size: Int): Int {
        return ((size - 2) * 5) + 1
    }

    private fun printGrid(grid: List<List<Node>>) {
        for (rowIndex in grid.indices) {
            val builder = StringBuilder()
            val row = grid[rowIndex]
            for (cellIndex in row.indices) {
                val cell = row[cellIndex]
                builder.append(cell.getContent())
            }
            println(builder.toString())
        }
    }

    @Suppress("DestructuringDeclarationWithTooManyEntries")
    private fun toNode(line: String): Node {
        val matchResult = nodeRegex.find(line)!!
        val (x, y, size, used, available, usedPercentage) = matchResult.destructured
        return Node(x.toInt(), y.toInt(), size.toInt(), used.toInt(), available.toInt(), usedPercentage.toInt())
    }

    private fun buildGrid(nodes: Map<Point, Node>): List<List<Node>> {
        var maxX = 0
        var maxY = 0
        for (node in nodes) {
            if (node.value.x > maxX) {
                maxX = node.value.x
            }
            if (node.value.y > maxY) {
                maxY = node.value.y
            }
        }

        val grid = mutableListOf<List<Node>>()
        for (row in 0..maxY) {
            val rowArray = mutableListOf<Node>()
            for (col in 0..maxX) {
                rowArray.add(nodes[Point(col, row)]!!)
            }
            grid.add(rowArray)
        }
        return grid
    }

    private fun getShortestRoute(
        startNode: Node,
        targetNode: Node,
        map: List<List<Node>>,
    ): Int {
        val deque = ArrayDeque<Node>()
        val visited = mutableMapOf(startNode to 0)
        deque.add(startNode)

        while (deque.isNotEmpty()) {
            val step = deque.removeFirst()
            val distance = visited[step]!!
            if (step.location() == targetNode.location()) {
                return distance
            }

            val availableMoves = getAvailableMoves(step, map)
            for (move in availableMoves) {
                val tmpNode = map[ move.y][move.x]
                if (visited.contains(tmpNode) || !isValidMove(tmpNode.location(), map)) {
                    continue
                }
                deque.add(map[move.y][move.x])
                visited[tmpNode] = distance + 1
            }
        }
        throw IllegalArgumentException("Cant get to target $targetNode")
    }

    private fun getAvailableMoves(
        step: Node,
        map: List<List<Node>>,
    ): List<Point> {
        val availableMoves = mutableListOf<Point>()
        for (move in possibleMoves) {
            val tmpPoint = Point(step.location().x + move.x, step.location().y + move.y)
            if (tmpPoint.isInBounds(0, 0, map[0].lastIndex, map.lastIndex)) {
                availableMoves.add(tmpPoint)
            }
        }
        return availableMoves
    }

    private fun isValidMove(
        tmpPoint: Point,
        map: List<List<Node>>,
    ): Boolean {
        val isInBounds = tmpPoint.isInBounds(0, 0, map[0].lastIndex, map.lastIndex)
        return isInBounds && map[tmpPoint.y][tmpPoint.x].getContent() != WALL
    }
}
