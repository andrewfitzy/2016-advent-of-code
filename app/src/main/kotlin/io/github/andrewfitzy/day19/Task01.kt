package io.github.andrewfitzy.day19

class Task01(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    fun solve(): Int {
        val numberOfElves = input[0].toInt()
        val elfMap = mutableMapOf<Int, Int>()
        for (elf in 1..numberOfElves) {
            elfMap[elf] = 1
        }
        while (elfMap.size > 1) {
            for (elf in 1..numberOfElves) {
                if (elfMap.contains(elf)) {
                    val nextElf = getNextElf(elf, numberOfElves, elfMap)
                    val value = elfMap.remove(nextElf)
                    val newVal = value?.plus(elfMap.get(elf)!!)
                    elfMap[elf] = newVal!!
                }
            }
        }
        return elfMap.keys.first()
    }

    private fun getNextElf(
        currentElf: Int,
        numberOfElves: Int,
        elfMap: MutableMap<Int, Int>,
    ): Int {
        var nextElf = -1

        for (elf in currentElf + 1..numberOfElves) {
            if (elfMap.contains(elf)) {
                nextElf = elf
                break
            }
        }
        if(nextElf > -1) {
            return nextElf
        }
        for (elf in 1..<currentElf) {
            if (elfMap.contains(elf)) {
                nextElf = elf
                break
            }
        }
        return nextElf
    }
}
