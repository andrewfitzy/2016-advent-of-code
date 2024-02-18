package io.github.andrewfitzy.day18

import io.github.andrewfitzy.util.appendAll

class Task02(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    private val trapPatterns: MutableSet<String> = mutableSetOf("^^.", ".^^", "^..", "..^")

    fun solve(numberOfRows: Int): Int {
        var currentRow = input[0]
        var runningTotal = countSafeTiles(currentRow)
        var count = 0
        val numberOfIterations = numberOfRows - 1
        while (count < numberOfIterations) {
            val rowBuilder = StringBuilder()
            for (j in currentRow.indices) {
                val testString = StringBuilder()
                testString.appendAll(
                    currentRow.getOrElse(j - 1) { '.' },
                    currentRow[j],
                    currentRow.getOrElse(j + 1) { '.' },
                )
                rowBuilder.append(getNewValue(testString.toString()))
            }
            runningTotal += countSafeTiles(rowBuilder.toString())
            currentRow = rowBuilder.toString()
            count++
        }
        return runningTotal
    }

    private fun getNewValue(testString: String): String {
        if (trapPatterns.contains(testString)) {
            return "^"
        }
        return "."
    }

    private fun countSafeTiles(row: String): Int {
        return row.count { it == '.' }
    }
}
