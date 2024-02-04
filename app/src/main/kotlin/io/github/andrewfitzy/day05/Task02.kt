package io.github.andrewfitzy.day05

import java.security.MessageDigest

private const val PASSWORD_LENGTH = 8

private const val CHARACTER_POSITION = 5

private const val CHARACTER_INDEX = 6

class Task02(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    fun solve(): String {
        val key = input[0]
        val positionMap: HashMap<Int, String> = HashMap()
        var index = 0
        while (positionMap.size != PASSWORD_LENGTH) {
            val md5Hash = md5(key + index)
            index++

            if (!md5Hash.startsWith("00000")) {
                continue
            }
            val positionStr = md5Hash[CHARACTER_POSITION].toString()
            if (positionStr.matches("[0-7]".toRegex())) {
                val position = positionStr.toInt()
                if (!positionMap.containsKey(position)) {
                    positionMap[position] = md5Hash[CHARACTER_INDEX].toString()
                }
            }
        }
        val builder = StringBuilder()
        for (i in 0 until PASSWORD_LENGTH) {
            builder.append(positionMap[i])
        }

        return builder.toString()
    }

    private fun md5(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        val digest = md.digest(input.toByteArray())
        return digest.joinToString("") { "%02x".format(it) }
    }
}
