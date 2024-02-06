package io.github.andrewfitzy.day07

class Task01(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    fun solve(): Int {
        var count = 0
        for (line in input) {
            val splits = line.split("[")
            val hypernetSplits =
                splits.filter { value -> value.contains("]") }
                    .map { value -> value.substringBefore("]") }
                    .filter { value -> containsPalindromeSequence(value) }
                    .toList()
            if (hypernetSplits.isNotEmpty()) {
                continue
            }

            val supernetSplits =
                splits.map { value -> value.substringAfter("]") }
                    .filter { value -> containsPalindromeSequence(value) }
                    .toList()
            if (supernetSplits.isNotEmpty()) {
                count++
            }
        }
        return count
    }

    @Suppress("MagicNumber") //I feel this is better than a constant called THREE
    private fun containsPalindromeSequence(split: String): Boolean {
        for (i in 3 until split.length) {
            if (split[i] == split[i - 3] && split[i - 1] == split[i - 2] && split[i] != split[i - 1]) {
                return true
            }
        }
        return false
    }
}
