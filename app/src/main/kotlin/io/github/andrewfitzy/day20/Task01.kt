package io.github.andrewfitzy.day20

class Task01(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    fun solve(): Long {
        val ipAddresses = mutableListOf<LongRange>()
        for (entry in input) {
            val range = inputToRange(entry)
            ipAddresses.add(range)
        }

        val sortedList =
            ipAddresses.sortedWith { a, b ->
                a.first.compareTo(b.first)
            }

        val ranges = reduceRanges(sortedList)

        val firstAllowedNumber = getFirstAllowedNumber(ranges)

        return firstAllowedNumber
    }

    private fun inputToRange(input: String): LongRange {
        val (start, end) = input.split("-")
        return LongRange(start.toLong(), end.toLong())
    }

    private fun reduceRanges(sortedList: List<LongRange>): MutableList<LongRange> {
        val ranges = mutableListOf<LongRange>()
        var tmpRange = sortedList.first()
        for (index in 1..<sortedList.size) {
            var updated = false
            val currentRange = sortedList[index]

            if (tmpRange.contains(currentRange.first) && tmpRange.contains(currentRange.last)) {
                continue
            }

            if (tmpRange.contains(currentRange.first) && tmpRange.last < currentRange.last) {
                tmpRange = LongRange(tmpRange.first, currentRange.last)
                updated = true
            }

            if (tmpRange.contains(currentRange.last) && tmpRange.first > currentRange.first) {
                tmpRange = LongRange(currentRange.first, tmpRange.last)
                updated = true
            }

            if (!updated) {
                ranges.add(tmpRange)
                tmpRange = currentRange
            }
        }
        ranges.add(tmpRange)
        return ranges
    }

    private fun getFirstAllowedNumber(ranges: MutableList<LongRange>): Long {
        var lowestValue = -1L
        for (index in 1..<ranges.size) {
            val previousEnd = ranges[index - 1].last
            if (!ranges[index].contains(previousEnd + 1)) {
                lowestValue = previousEnd + 1
                break
            }
        }
        return lowestValue
    }
}
