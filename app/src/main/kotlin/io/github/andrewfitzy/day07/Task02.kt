package io.github.andrewfitzy.day07

import io.github.andrewfitzy.util.appendAll

class Task02(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    fun solve(): Int {
        var count = 0
        for (line in input) {
            val splits = line.split("[")
            val hypernetSplits =
                splits.filter { value -> value.contains("]") }
                    .map { value -> value.substringBefore("]") }
                    .toList()
            val hypernetBABs: MutableSet<String> = mutableSetOf()
            for (hypernetSplit in hypernetSplits) {
                hypernetBABs.addAll(getThreeLetterPalindromes(hypernetSplit))
            }

            val supernetSplits = splits.map { value -> value.substringAfter("]") }.toList()
            val supernetABAs: MutableSet<String> = mutableSetOf()
            for (supernetSplit in supernetSplits) {
                supernetABAs.addAll(getThreeLetterPalindromes(supernetSplit))
            }
            if (hypernetBABs.isEmpty() || supernetABAs.isEmpty()) {
                continue
            }

            for (bab in hypernetBABs) {
                if (supernetABAs.contains(getBABToABA(bab))) {
                    count++
                    break
                }
            }
        }
        return count
    }

    private fun getBABToABA(bab: String): String {
        val builder = StringBuilder()
        builder.appendAll(bab[1], bab[0], bab[1])
        return builder.toString()
    }

    private fun getThreeLetterPalindromes(value: String): Set<String> {
        val tlps: MutableSet<String> = mutableSetOf()
        for (i in 2 until value.length) {
            if (value[i] == value[i - 2] && value[i] != value[i - 1]) {
                val builder = StringBuilder()
                builder.appendAll(value[i - 2], value[i - 1], value[i])
                tlps.add(builder.toString())
            }
        }
        return tlps
    }
}
