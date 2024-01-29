package io.github.andrewfitzy.dayxx

class Task01 constructor(puzzleInput: List<String>) {
    private val input: List<String>

    init {
        input = puzzleInput
    }

    fun solve(): Int {
        return input.size
    }
}
