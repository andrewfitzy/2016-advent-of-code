package io.github.andrewfitzy.day05

import java.security.MessageDigest

private const val PASSWORD_LENGTH = 8

private const val CHARACTER_INDEX = 5

class Task01(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    fun solve(): String {
        val key = input[0]
        val builder = StringBuilder()
        var index = 0
        while (builder.length != PASSWORD_LENGTH) {
            val md5Hash = md5(key + index)
            index++

            if (md5Hash.startsWith("00000")) {
                builder.append(md5Hash[CHARACTER_INDEX])
            }
        }
        return builder.toString()
    }

    private fun md5(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        val digest = md.digest(input.toByteArray())
        return digest.joinToString("") { "%02x".format(it) }
    }
}
