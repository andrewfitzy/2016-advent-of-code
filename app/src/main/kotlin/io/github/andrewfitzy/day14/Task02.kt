package io.github.andrewfitzy.day14

import io.github.andrewfitzy.util.appendAll
import io.github.andrewfitzy.util.md5

private const val MAX_RANGE = 1000

private const val TRIPLE_LENGTH = 3

private const val QUINTUPLE_LENGTH = 5

private const val HASH_STRETCHING_ITERATIONS = 2016

class Task02(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    fun solve(targetKeyIndex: Int): Int {
        val salt = input[0]
        var i = 0
        val validIndexes: MutableSet<Int> = mutableSetOf()
        val tracking: MutableMap<String, MutableList<Int>> = mutableMapOf()
        while (validIndexes.size < targetKeyIndex) {
            val testString = salt + i
            val md5Hash = stretchHash(testString.md5())

            val triples = getRepeatingChars(md5Hash, TRIPLE_LENGTH)
            if (triples.isNotEmpty()) {
                val triple = triples.first()
                val tripleIndexes = tracking.getOrDefault(triple, mutableListOf())
                tripleIndexes.add(i)
                tracking[triple] = tripleIndexes
            }

            val quintuples = getRepeatingChars(md5Hash, QUINTUPLE_LENGTH)
            for (quint in quintuples) {
                val matchingTriplesIndexes = getMatchingTriplesIndexes(quint, tracking, i)
                validIndexes.addAll(matchingTriplesIndexes)
            }
            i++
        }
        val indexList: List<Int> = validIndexes.toList().sorted()
        return indexList[targetKeyIndex - 1]
    }

    private fun stretchHash(md5Hash: String): String {
        var stretchedHash = md5Hash
        var j = 0
        while (j < HASH_STRETCHING_ITERATIONS) {
            stretchedHash = stretchedHash.md5()
            j++
        }
        return stretchedHash
    }

    private fun getMatchingTriplesIndexes(
        quint: String,
        tracking: MutableMap<String, MutableList<Int>>,
        currentIndex: Int,
    ): MutableSet<Int> {
        val matchingTriples = mutableSetOf<Int>()
        val tmpTriple = StringBuilder()
        tmpTriple.appendAll(quint[0], quint[0], quint[0])
        val indexes = tracking.getOrDefault(tmpTriple.toString(), mutableListOf())
        for (index in indexes) {
            val range = currentIndex - MAX_RANGE
            if (index != currentIndex && index >= range) {
                matchingTriples.add(index)
            }
        }
        return matchingTriples
    }

    private fun getRepeatingChars(
        md5Hash: String,
        matchedStringLength: Int,
    ): MutableList<String> {
        val repeatingChars: MutableList<String> = mutableListOf()
        for (i in matchedStringLength - 1 until md5Hash.length) {
            var found = true
            for (j in 1 until matchedStringLength) {
                if (md5Hash[i] != md5Hash[i - j]) {
                    found = false
                    break
                }
            }
            if (found) {
                val builder =
                    StringBuilder().apply {
                        repeat(matchedStringLength) {
                            append(md5Hash[i])
                        }
                    }
                repeatingChars.add(builder.toString())
            }
        }
        return repeatingChars
    }
}
