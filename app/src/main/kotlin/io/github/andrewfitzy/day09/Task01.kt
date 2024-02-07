package io.github.andrewfitzy.day09

class Task01(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    fun solve(): Int {
        val line = input.first()
        var pointer = 0
        var length = 0
        while (pointer < line.length) {
            if (line[pointer] == '(') {
                val subs = line.substring(pointer + 1, line.indexOf(')', pointer))

                pointer += subs.length + 2

                val chars = subs.split("x")[0].toInt()
                val repeats = subs.split("x")[1].toInt()

                val repeatString = line.substring(pointer, pointer + chars)
                length += repeats * repeatString.length
                pointer += repeatString.length
            } else {
                pointer++
                length++
            }
        }
        return length
    }
}
