package io.github.andrewfitzy.util

import java.security.MessageDigest

fun String.md5(): String {
    val md = MessageDigest.getInstance("MD5")
    val digest = md.digest(toByteArray())
    return digest.joinToString("") { "%02x".format(it) }
}

fun String.getPermutations(): List<String> {
    val permutations = mutableListOf<String>()
    buildPermutationsRecursively(toMutableList(), permutations, 0)
    return permutations
}

private fun buildPermutationsRecursively(
    inputString: MutableList<Char>,
    permutations: MutableList<String>,
    index: Int,
) {
    if (index == inputString.lastIndex) {
        permutations.add(inputString.joinToString(separator = ""))
    }
    for (i in index..inputString.lastIndex) {
        swap(inputString, index, i)
        buildPermutationsRecursively(inputString, permutations, index + 1)
        swap(inputString, i, index)
    }
}

private fun swap(
    currentValue: MutableList<Char>,
    a: Int,
    b: Int,
) {
    val tmp = currentValue[a]
    currentValue[a] = currentValue[b]
    currentValue[b] = tmp
}
