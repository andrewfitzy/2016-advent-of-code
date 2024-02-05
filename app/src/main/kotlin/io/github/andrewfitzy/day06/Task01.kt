package io.github.andrewfitzy.day06

class Task01(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    fun solve(): String {
        val charCounter: MutableMap<Int, MutableMap<String, Int>> = mutableMapOf()
        for (inputLine in input) {
            for (i in inputLine.indices) {
                val colChars: MutableMap<String, Int> = charCounter.getOrDefault(i, mutableMapOf())
                val colChar: String = inputLine[i].toString()
                val colCharCount = colChars.getOrDefault(colChar, 0) + 1
                colChars[colChar] = colCharCount
                charCounter[i] = colChars
            }
        }

        val builder = StringBuilder()
        for (i in 0 until charCounter.size) {
            var highestValue = 0
            var highestValueChar = ""
            val colChars: MutableMap<String, Int> = charCounter[i]!!
            for (entry in colChars.entries) {
                if (entry.value > highestValue) {
                    highestValue = entry.value
                    highestValueChar = entry.key
                }
            }
            builder.append(highestValueChar)
        }

        return builder.toString()
    }
}
