package io.github.andrewfitzy.day15

class Task02(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    fun solve(): Int {
        val inputRegex = "Disc #(\\d+) has (\\d+) positions; at time=0, it is at position (\\d+).".toRegex()

        val discs = mutableListOf<Disc>()
        for (entry in input) {
            val matchResult = inputRegex.find(entry)!!
            val (numberStr, positionsStr, currentPositionStr) = matchResult.destructured
            val number = numberStr.toInt()
            val positions = positionsStr.toInt()
            val currentPosition = currentPositionStr.toInt()

            discs.add(Disc(number, positions, currentPosition))
        }

        var buttonPressSeconds = 0
        while(buttonPressSeconds < Int.MAX_VALUE) {
            var goodDrop = true
            for(disc in discs) {
                //using disc.number to account for number of seconds since button press.
                val alignedPosition = (buttonPressSeconds + disc.number + disc.currentPosition) % disc.positions
                if(alignedPosition != 0) {
                    goodDrop = false
                    break
                }
            }
            if(goodDrop) {
                break
            }
            buttonPressSeconds += 1
        }

        return buttonPressSeconds
    }
}
