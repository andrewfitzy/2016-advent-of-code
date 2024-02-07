package io.github.andrewfitzy.day09

class Task02(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    fun solve(): Long {
        val line = input.first()
        val length = getDecompressedChunkLength(line)
        return length
    }

    private fun getDecompressedChunkLength(chunk: String): Long {
        var pointer = 0
        var length = 0L
        while (pointer < chunk.length) {
            if (chunk[pointer] == '(') {
                val subs = chunk.substring(pointer + 1, chunk.indexOf(')', pointer))

                pointer += subs.length + 2

                val chars = subs.split("x")[0].toInt()
                val repeats = subs.split("x")[1].toInt()

                val repeatString = chunk.substring(pointer, pointer + chars)
                if (repeatString.contains("(")) {
                    length += repeats * getDecompressedChunkLength(repeatString)
                } else {
                    length += chars * repeats
                }
                pointer += repeatString.length
            } else {
                pointer++
                length++
            }
        }
        return length
    }
}
