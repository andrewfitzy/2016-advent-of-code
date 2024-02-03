package io.github.andrewfitzy.day04

class Task01(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    fun solve(): Int {
        var checksumTotal = 0
        for (entry in input) {
            val splits = entry.split("-")
            val name = splits.subList(0, splits.size - 1).joinToString(separator = "")
            val lastItem = splits[splits.size - 1]
            val sectorId = lastItem.substring(0, lastItem.indexOf("[")).toInt()
            val checksum = lastItem.substring(lastItem.indexOf("[") + 1, lastItem.indexOf("]"))
            if (isValidInput(name, checksum)) {
                println(name)
                checksumTotal += sectorId
            }
        }
        return checksumTotal
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
}
