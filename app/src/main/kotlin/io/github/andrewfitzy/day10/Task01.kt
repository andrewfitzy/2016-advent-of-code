package io.github.andrewfitzy.day10

@Suppress("MagicNumber") // I feel this is better than all the constants
class Task01(puzzleInput: List<String>) {
    private val input: MutableList<String> = ArrayList(puzzleInput)

    fun solve(pair: Pair<Int, Int>): Int {
        val bots: MutableMap<Int, MutableList<Int>> = mutableMapOf()
        val outputBins: MutableMap<Int, MutableList<Int>> = mutableMapOf()

        var specialBot = -1
        val seen: MutableSet<String> = mutableSetOf()
        var complete = false
        while (!complete) {
            val line = input.removeAt(0)
            input.add(line)

            if (line.startsWith("value")) {
                if (!seen.contains(line)) {
                    addValueToBot(line, bots)
                    seen.add(line)
                }
            }

            if (line.startsWith("bot")) {
                val splits = line.split(" ")
                val bot = splits[1].toInt()

                val botChips = bots.getOrDefault(bot, mutableListOf()).sorted()
                if (botChips.contains(pair.first) && botChips.contains(pair.second)) {
                    specialBot = bot
                }
                if (botChips.size == 2) {
                    val lowTargetType = splits[5]
                    val lowTargetNumber = splits[6].toInt()
                    val highTargetType = splits[10]
                    val highTargetNumber = splits[11].toInt()
                    updateTargetBins(lowTargetType, lowTargetNumber, botChips[0], bots, outputBins)
                    updateTargetBins(highTargetType, highTargetNumber, botChips[1], bots, outputBins)
                    bots[bot] = mutableListOf()
                }
            }
            complete = isComplete(bots)
        }

        return specialBot
    }

    private fun isComplete(bots: MutableMap<Int, MutableList<Int>>): Boolean {
        return bots.values.all { it.isEmpty() }
    }

    private fun addValueToBot(
        line: String,
        bots: MutableMap<Int, MutableList<Int>>,
    ) {
        val splits = line.split(" ")
        val value = splits[1].toInt()
        val bot = splits[5].toInt()

        val botChips = bots.getOrDefault(bot, mutableListOf())
        botChips.add(value)
        bots[bot] = botChips
    }

    private fun updateTargetBins(
        targetType: String,
        targetNumber: Int,
        chip: Int,
        bots: MutableMap<Int, MutableList<Int>>,
        outputBins: MutableMap<Int, MutableList<Int>>,
    ) {
        val targetMap = if (targetType == "bot") bots else outputBins
        targetMap.getOrPut(targetNumber) { mutableListOf() }.add(chip)
    }
}
