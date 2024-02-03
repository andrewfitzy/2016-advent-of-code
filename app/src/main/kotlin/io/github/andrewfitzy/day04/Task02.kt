package io.github.andrewfitzy.day04

private const val LETTERS_IN_ALPHABET = 26

private const val LOWER_Z_VALUE = 122

private const val LOWER_A_VALUE = 96

class Task02(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    fun solve(targetRoom: String): Int {
        var targetSectorId = 0
        for (entry in input) {
            val splits = entry.split("-")
            val nameSplits = splits.subList(0, splits.size - 1)
            val name = nameSplits.joinToString(separator = "")
            val lastItem = splits[splits.size - 1]
            val sectorId = lastItem.substring(0, lastItem.indexOf("[")).toInt()
            val checksum = lastItem.substring(lastItem.indexOf("[") + 1, lastItem.indexOf("]"))
            if (isValidInput(name, checksum)) {
                val decryptedName = decrypt(nameSplits, sectorId)
                if (targetRoom == decryptedName) {
                    targetSectorId = sectorId
                    break
                }
            }
        }
        return targetSectorId
    }

    private fun isValidInput(
        name: String,
        checksum: String,
    ): Boolean {
        val charCount = name.groupingBy { it }.eachCount()

        val entries = ArrayList(charCount.entries)
        val sortedList =
            entries.sortedWith { a, b ->
                when {
                    a.value < b.value -> 1
                    a.value > b.value -> -1
                    a.value == b.value && a.key > b.key -> 1
                    a.value == b.value && a.key < b.key -> -1
                    else -> 0
                }
            }

        return checksum == sortedList.subList(0, checksum.length).joinToString(separator = "") { it.key.toString() }
    }

    private fun decrypt(
        nameWords: List<String>,
        sectorId: Int,
    ): String {
        val shift = sectorId % LETTERS_IN_ALPHABET
        val nameSplits = nameWords.map { name -> decryptName(name, shift) }
        return nameSplits.joinToString(separator = " ")
    }

    private fun decryptName(
        name: String,
        shift: Int,
    ): String {
        val builder = StringBuilder()
        for (letter in name.toCharArray()) {
            var newLetterCode = letter.code + shift
            if (newLetterCode > LOWER_Z_VALUE) {
                newLetterCode = LOWER_A_VALUE + (newLetterCode - LOWER_Z_VALUE)
            }
            builder.append(newLetterCode.toChar())
        }
        return builder.toString()
    }
}
