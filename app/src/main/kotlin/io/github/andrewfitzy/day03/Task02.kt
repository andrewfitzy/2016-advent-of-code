package io.github.andrewfitzy.day03

private const val NUMBER_OF_SIDES = 3

class Task02(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    fun solve(): Int {
        var count = 0
        val column01 = mutableListOf<Int>()
        val column02 = mutableListOf<Int>()
        val column03 = mutableListOf<Int>()
        for (entry in input) {
            val sides =
                entry.split("\\s+".toRegex())
                    .filter { value -> value.trim().isNotEmpty() }
                    .map { value -> value.trim().toInt() }
            column01.add(sides[0])
            column02.add(sides[1])
            column03.add(sides[2])
        }
        val consolidatedList = column01 + column02 + column03
        val chunkedList = consolidatedList.chunked(NUMBER_OF_SIDES)
        for (chunk in chunkedList) {
            if (isValidTriangle(chunk)) {
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
