package io.github.andrewfitzy.day03

private const val NUMBER_OF_SIDES = 3

class Task01(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    fun solve(): Int {
        var count = 0
        for (entry in input) {
            val sides =
                entry.split("\\s+".toRegex())
                    .filter { value -> value.trim().isNotEmpty() }
                    .map { value -> value.trim().toInt() }
            if (isValidTriangle(sides)) {
                count++
            }
        }
        return count
    }

    private fun isValidTriangle(sides: List<Int>): Boolean {
        if (sides.size != NUMBER_OF_SIDES) {
            return false
        }
        return (sides[0] + sides[1] > sides [2] && sides[1] + sides[2] > sides [0] && sides[0] + sides[2] > sides [1])
    }
}
