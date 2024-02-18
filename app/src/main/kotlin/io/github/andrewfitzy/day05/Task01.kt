package io.github.andrewfitzy.day05

import io.github.andrewfitzy.util.md5

private const val PASSWORD_LENGTH = 8

private const val CHARACTER_INDEX = 5

class Task01(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    fun solve(): String {
        val key = input[0]
        val builder = StringBuilder()
        var index = 0
        while (builder.length != PASSWORD_LENGTH) {
            val testString = key + index
            val md5Hash = testString.md5()
            index++

            if (md5Hash.startsWith("00000")) {
                builder.append(md5Hash[CHARACTER_INDEX])
            }
        }
        return builder.toString()
    }
}
