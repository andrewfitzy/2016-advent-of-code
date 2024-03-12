package io.github.andrewfitzy.day20

class Task02(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    fun solve(maxNumber: Long): Long {
        val ipAddresses = mutableListOf<LongRange>()
        for (entry in input) {
            val range = inputToRange(entry)
            ipAddresses.add(range)
        }

        val sortedList =
            ipAddresses.sortedWith { a, b ->
                a.first.compareTo(b.first)
            }

        val reducedRanges = reduceRanges(sortedList)

        val negatedRanges = negateRanges(reducedRanges, maxNumber)

        val totalAllowedNumbers = getTotalAllowedNumbers(negatedRanges)

        return totalAllowedNumbers
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

    private fun negateRanges(
        reducedRanges: MutableList<LongRange>,
        maxNumber: Long,
    ): MutableList<LongRange> {
        val negatedRanges = mutableListOf<LongRange>()
        for (index in 1..<reducedRanges.size) {
            val previousEndPlusOne = reducedRanges[index - 1].last + 1
            if (!reducedRanges[index].contains(previousEndPlusOne)) {
                negatedRanges.add(LongRange(previousEndPlusOne, reducedRanges[index].first - 1))
            }
        }
        if (!reducedRanges.last().contains(maxNumber)) {
            negatedRanges.add(LongRange(reducedRanges.last().last + 1, maxNumber))
        }
        return negatedRanges
    }

    private fun getTotalAllowedNumbers(ranges: MutableList<LongRange>): Long {
        var totalAllowed = 0L
        for (index in 0..<ranges.size) {
            val tmpRange = ranges[index]
            val rangeSize = (tmpRange.last - tmpRange.first) + 1L
            totalAllowed += rangeSize
        }
        return totalAllowed
    }
}
