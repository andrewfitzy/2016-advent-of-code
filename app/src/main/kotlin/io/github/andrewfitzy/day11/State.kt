package io.github.andrewfitzy.day11

private const val FINAL_FLOOR = 4

data class State(
    val elevator: Int,
    val floorOne: Set<String>,
    val floorTwo: Set<String>,
    val floorThree: Set<String>,
    val floorFour: Set<String>,
) {
    fun isFinished(): Boolean {
        return elevator == FINAL_FLOOR &&
            floorOne.isEmpty() &&
            floorTwo.isEmpty() &&
            floorThree.isEmpty() &&
            floorFour.isNotEmpty()
    }
}
