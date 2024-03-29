package io.github.andrewfitzy.day24

import io.github.andrewfitzy.util.Point
import io.github.andrewfitzy.util.getPermutations
import java.util.ArrayDeque

private const val WALL = '#'

class Task02(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput
    private val possibleMoves = listOf(Point(-1, 0), Point(1, 0), Point(0, -1), Point(0, 1))

    fun solve(): Int {
        val map = buildMap()
        val stepsOfInterest = getStepsOfInterest(map)
        val pairsOfSteps = getPairsOfSteps(stepsOfInterest)
        val shortestDistances = getShortestDistances(pairsOfSteps, map)

        val possibleRoutes = getPossibleRoutes(stepsOfInterest)

        var shortestRouteLength = Int.MAX_VALUE
        var shortestRoute = ""
        for (route in possibleRoutes) {
            var routeLength = 0
            val chars = route.toList()
            for (i in 1 until chars.size) {
                val leg = Pair(chars[i - 1], chars[i])
                routeLength += shortestDistances[leg]!!
            }
            if (routeLength < shortestRouteLength) {
                shortestRouteLength = routeLength
                shortestRoute = route
            }
        }
        println("$shortestRoute = $shortestRouteLength")
        return shortestRouteLength
    }

    private fun buildMap(): List<List<Step>> {
        val map = mutableListOf<List<Step>>()
        for (row in 0..input.lastIndex) {
            val rowArray = mutableListOf<Step>()
            for (col in 0..input[row].lastIndex) {
                rowArray.add(Step(Point(col, row), input[row][col]))
            }
            map.add(rowArray)
        }
        return map
    }

    private fun getStepsOfInterest(map: List<List<Step>>): List<Step> {
        val stepsOfInterest = mutableListOf<Step>()
        for (row in 0..map.lastIndex) {
            for (col in 0..map[row].lastIndex) {
                if (!".#".contains(map[row][col].content)) {
                    stepsOfInterest.add(map[row][col])
                }
            }
        }
        return stepsOfInterest
    }

    private fun getPairsOfSteps(stepsOfInterest: List<Step>): List<Pair<Step, Step>> {
        val pairsOfSteps = mutableListOf<Pair<Step, Step>>()
        for (i in 0..<stepsOfInterest.lastIndex) {
            for (j in i + 1..stepsOfInterest.lastIndex) {
                pairsOfSteps.add(Pair(stepsOfInterest[i], stepsOfInterest[j]))
            }
        }
        return pairsOfSteps
    }

    private fun getShortestDistances(
        pairsOfSteps: List<Pair<Step, Step>>,
        map: List<List<Step>>,
    ): Map<Pair<Char, Char>, Int> {
        val shortestDistances = mutableMapOf<Pair<Char, Char>, Int>()
        for (leg in pairsOfSteps) {
            val shortestRoute = getShortestRoute(leg.first, leg.second, map)
            shortestDistances[Pair(leg.first.content, leg.second.content)] = shortestRoute
            shortestDistances[Pair(leg.second.content, leg.first.content)] = shortestRoute
        }
        return shortestDistances
    }

    private fun getShortestRoute(
        startPoint: Step,
        targetPoint: Step,
        map: List<List<Step>>,
    ): Int {
        val deque = ArrayDeque<Step>()
        val visited = mutableMapOf(startPoint.location to 0)
        deque.add(startPoint)

        while (deque.isNotEmpty()) {
            val step = deque.removeFirst()
            val distance = visited[step.location]!!
            if (step.location == targetPoint.location) {
                return distance
            }

            for (move in possibleMoves) {
                val tmpPoint = map[ step.location.y + move.y][step.location.x + move.x].location
                if (visited.contains(tmpPoint) || !isValidMove(tmpPoint, map)) {
                    continue
                }
                deque.add(map[tmpPoint.y][tmpPoint.x])
                visited[tmpPoint] = distance + 1
            }
        }
        throw IllegalArgumentException("Cant get to target $targetPoint")
    }

    private fun isValidMove(
        tmpPoint: Point,
        map: List<List<Step>>,
    ): Boolean {
        val isInBounds = tmpPoint.isInBounds(0, 0, map[0].lastIndex, map.lastIndex)
        return isInBounds && map[tmpPoint.y][tmpPoint.x].content != WALL
    }

    private fun getPossibleRoutes(stepsOfInterest: List<Step>): List<String> {
        val builder = StringBuilder()
        for (step in stepsOfInterest) {
            builder.append(step.content)
        }
        val routes =
            builder.toString().getPermutations()
                .filter { route -> route.startsWith('0') }
                .map { route -> "${route}0" }
        return routes
    }
}
