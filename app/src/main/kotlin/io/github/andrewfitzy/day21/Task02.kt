package io.github.andrewfitzy.day21

import io.github.andrewfitzy.util.UnexpectedInputException
import io.github.andrewfitzy.util.getPermutations

private const val MINIMUM_INDEX_THRESHOLD = 4

class Task02(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    private val swapPosition = "swap position (\\d) with position (\\d)".toRegex()
    private val swapLetter = "swap letter ([a-z]) with letter ([a-z])".toRegex()
    private val rotateDirection = "rotate (left|right) (\\d) steps?".toRegex()
    private val rotatePosition = "rotate based on position of letter ([a-z])".toRegex()
    private val reverse = "reverse positions (\\d) through (\\d)".toRegex()
    private val move = "move position (\\d) to position (\\d)".toRegex()

    fun solve(inputString: String): String {
        var result = ""
        val permutations = inputString.getPermutations()
        for (permutation in permutations) {
            val scrambledValue = getScrambledValue(permutation)
            if (scrambledValue == inputString) {
                result = permutation
            }
        }
        return result
    }

    private fun getScrambledValue(inputString: String): String {
        var currentValue = inputString.toMutableList()
        for (entry in input) {
            if (entry.matches(swapPosition)) {
                val matchResult = swapPosition.find(entry)!!
                val (positionX, positionY) = matchResult.destructured
                currentValue = swapPosition(currentValue, positionX.toInt(), positionY.toInt())
            } else if (entry.matches(swapLetter)) {
                val matchResult = swapLetter.find(entry)!!
                val (letterX, letterY) = matchResult.destructured
                currentValue = swapLetter(currentValue, letterX.first(), letterY.first())
            } else if (entry.matches(rotateDirection)) {
                val matchResult = rotateDirection.find(entry)!!
                val (direction, steps) = matchResult.destructured
                currentValue = rotateDirection(currentValue, direction, steps.toInt())
            } else if (entry.matches(rotatePosition)) {
                val matchResult = rotatePosition.find(entry)!!
                val (pivot) = matchResult.destructured
                currentValue = rotatePosition(currentValue, pivot.first())
            } else if (entry.matches(reverse)) {
                val matchResult = reverse.find(entry)!!
                val (startPosition, endPosition) = matchResult.destructured
                currentValue = reverse(currentValue, startPosition.toInt(), endPosition.toInt())
            } else if (entry.matches(move)) {
                val matchResult = move.find(entry)!!
                val (startPosition, endPosition) = matchResult.destructured
                currentValue = move(currentValue, startPosition.toInt(), endPosition.toInt())
            } else {
                throw UnexpectedInputException("Unknown command: $entry")
            }
        }
        return currentValue.joinToString(separator = "")
    }

    fun swapPosition(
        currentValue: MutableList<Char>,
        positionX: Int,
        positionY: Int,
    ): MutableList<Char> {
        // swap position X with position Y means that the letters at indexes X and Y (counting from 0) should be
        // swapped.
        val newValue = currentValue.toMutableList()
        val letterX = newValue[positionX]
        val letterY = newValue[positionY]
        newValue[positionX] = letterY
        newValue[positionY] = letterX
        return newValue
    }

    fun swapLetter(
        currentValue: MutableList<Char>,
        letterX: Char,
        letterY: Char,
    ): MutableList<Char> {
        // swap letter X with letter Y means that the letters X and Y should be swapped (regardless of where they appear
        // in the string).
        val newValue = currentValue.toMutableList()
        val positionX = newValue.indexOf(letterX)
        val positionY = newValue.indexOf(letterY)
        newValue[positionX] = letterY
        newValue[positionY] = letterX
        return newValue
    }

    fun rotateDirection(
        currentValue: MutableList<Char>,
        direction: String,
        steps: Int,
    ): MutableList<Char> {
        // rotate left/right X steps means that the whole string should be rotated; for example, one right rotation
        // would turn abcd into dabc.

        var chopPoint = -1
        if ("left" == direction) {
            chopPoint = 0 + steps
        } else if ("right" == direction) {
            chopPoint = currentValue.size - steps
        }

        val start = currentValue.subList(0, chopPoint).toMutableList()
        val end = currentValue.subList(chopPoint, currentValue.size).toMutableList()

        val newValue = mutableListOf<Char>()
        newValue.addAll(end)
        newValue.addAll(start)
        return newValue
    }

    fun rotatePosition(
        currentValue: MutableList<Char>,
        pivot: Char,
    ): MutableList<Char> {
        // rotate based on position of letter X means that the whole string should be rotated to the right based on
        // the index of letter X (counting from 0) as determined before this instruction does any rotations. Once the
        // index is determined, rotate the string to the right one time, plus a number of times equal to that index,
        // plus one additional time if the index was at least 4.
        var chopPoint = currentValue.indexOf(pivot)
        if (chopPoint >= MINIMUM_INDEX_THRESHOLD) {
            chopPoint++
        }
        chopPoint++

        chopPoint %= currentValue.size
        chopPoint = currentValue.size - chopPoint

        val start = currentValue.subList(0, chopPoint).toMutableList()
        val end = currentValue.subList(chopPoint, currentValue.size).toMutableList()

        val newValue = mutableListOf<Char>()
        newValue.addAll(end)
        newValue.addAll(start)
        return newValue
    }

    fun reverse(
        currentValue: MutableList<Char>,
        startPosition: Int,
        endPosition: Int,
    ): MutableList<Char> {
        // reverse positions X through Y means that the span of letters at indexes X through Y (including the
        // letters at X and Y) should be reversed in order.
        val start = currentValue.subList(0, startPosition).toMutableList()
        val middle = currentValue.subList(startPosition, endPosition + 1).toMutableList()
        val end = currentValue.subList(endPosition + 1, currentValue.size).toMutableList()

        val newValue = mutableListOf<Char>()
        newValue.addAll(start)
        newValue.addAll(middle.asReversed())
        newValue.addAll(end)

        return newValue
    }

    fun move(
        currentValue: MutableList<Char>,
        startPosition: Int,
        endPosition: Int,
    ): MutableList<Char> {
        // move position X to position Y means that the letter which is at index X should be removed from the string,
        // then inserted such that it ends up at index Y.
        val newValue = currentValue.toMutableList()
        val letter = newValue.removeAt(startPosition)
        if (endPosition >= newValue.size) {
            newValue.add(letter)
        } else {
            newValue.add(endPosition, letter)
        }
        return newValue
    }
}
