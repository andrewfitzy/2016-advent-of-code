package io.github.andrewfitzy.day19

class Task02(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    fun solve(): Int {
        val numberOfElves = input[0].toInt()

        val elfList = mutableListOf<Int>()
        for (elf in 1..numberOfElves) {
            elfList.add(elf)
        }
        val elfSet = mutableSetOf<Int>()
        while (elfList.size > 1) {
            for (elf in 1..numberOfElves) {
                if (!elfSet.contains(elf)) {
                    val oppositeElf = getOppositeElf(elf, elfList)
                    elfSet.add(oppositeElf.second)
                    elfList.removeAt(oppositeElf.first)
                }
            }
        }
        return elfList.first()
    }

    private fun getOppositeElf(
        currentElf: Int,
        elfList: MutableList<Int>,
    ): Pair<Int, Int> {
        val currentElfIndex = elfList.indexOf(currentElf)

        val size = elfList.size
        val oppositeElfDistance = size.floorDiv(2)

        val oppositeElfIndex: Int
        val remainingElves = elfList.size - (currentElfIndex + 1)
        if (remainingElves >= oppositeElfDistance) {
            oppositeElfIndex = currentElfIndex + oppositeElfDistance
        } else {
            val shift = oppositeElfDistance - remainingElves
            oppositeElfIndex = shift - 1
        }

        return Pair(oppositeElfIndex, elfList[oppositeElfIndex])
    }
}
