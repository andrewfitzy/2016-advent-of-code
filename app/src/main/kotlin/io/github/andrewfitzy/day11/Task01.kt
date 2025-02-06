package io.github.andrewfitzy.day11

private const val FLOOR_ONE = 1
private const val FLOOR_TWO = 2
private const val FLOOR_THREE = 3
private const val FLOOR_FOUR = 4

private const val GENERATOR = "generator"
private const val MICROCHIP = "microchip"

class Task01(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    fun solve(): Int {
        val inputRegex = "\\b(\\w+(?:-\\w+)?\\s(?:generator|microchip))\\b".toRegex()
        val stateMap = mutableMapOf<Int, Set<String>>()

        var floorCount = 1
        for (floor in input) {
            val matches = inputRegex.findAll(floor).map { it.groupValues[1] }.toList()
            stateMap[floorCount] = matches.toSet()
            floorCount++
        }
        val state =
            State(
                FLOOR_ONE,
                stateMap[FLOOR_ONE]!!,
                stateMap[FLOOR_TWO]!!,
                stateMap[FLOOR_THREE]!!,
                stateMap[FLOOR_FOUR]!!,
            )

        val result = getShortestRoute(state)
        return result
    }

    private fun getShortestRoute(stateMap: State): Int {
        val deque = ArrayDeque<Step>()
        val start = Step(0, stateMap)
        deque.add(start)
        val seen = mutableSetOf<State>()
        while (!deque.isEmpty()) {
            val step = deque.removeFirst()
            if (step.state.isFinished()) {
                return step.cost
            }

            val availableMoves = getAvailableMoves(step.state)
            for (move in availableMoves) {
                if (seen.contains(move)) {
                    continue
                }
                seen.add(move)

                val tmpStep = Step(step.cost + 1, move)
                deque.add(tmpStep)
            }
        }

        error("We should have found an end state")
    }

    private fun getAvailableMoves(state: State): List<State> {
        val availableStates = mutableListOf<State>()

        // Elevator can go up, add the up states from current state
        if (FLOOR_ONE == state.elevator || FLOOR_TWO == state.elevator || FLOOR_THREE == state.elevator) {
            val nextElevator = state.elevator + 1
            val moves = getValidMoves(state.elevator, nextElevator, state)
            availableStates.addAll(moves)
        }

        // Elevator can go down, add the down states from current state
        if (FLOOR_TWO == state.elevator || FLOOR_THREE == state.elevator || FLOOR_FOUR == state.elevator) {
            val nextElevator = state.elevator - 1
            val moves = getValidMoves(state.elevator, nextElevator, state)
            availableStates.addAll(moves)
        }

        return availableStates
    }

    private fun getValidMoves(
        currentElevator: Int,
        nextElevator: Int,
        state: State,
    ): List<State> {
        val validMoves = mutableListOf<State>()
        val currentFloor =
            when (currentElevator) {
                FLOOR_ONE -> state.floorOne.toList()
                FLOOR_TWO -> state.floorTwo.toList()
                FLOOR_THREE -> state.floorThree.toList()
                else -> state.floorFour.toList()
            }

        val nextFloor =
            when (nextElevator) {
                FLOOR_ONE -> state.floorOne.toList()
                FLOOR_TWO -> state.floorTwo.toList()
                FLOOR_THREE -> state.floorThree.toList()
                else -> state.floorFour.toList()
            }
        // 1. build known movement combos
        val movementCombinations = buildMovementCombinations(currentFloor)

        // 2. for each movement combo
        for (movement in movementCombinations) {
            val currentFloorToBe = mutableListOf<String>()
            for (item in currentFloor) {
                if (!movement.contains(item)) {
                    currentFloorToBe.add(item)
                }
            }
            val nextFloorToBe = movement.toMutableList()
            nextFloorToBe.addAll(nextFloor)
            // 3. validate the floor left behind
            val newCurrentFloorValid = floorIsValid(currentFloorToBe)
            // 4. validate the floor to be
            val newNextFloorValid = floorIsValid(nextFloorToBe)

            if (newCurrentFloorValid && newNextFloorValid) {
                validMoves.add(buildNextState(currentElevator, nextElevator, currentFloorToBe, nextFloorToBe, state))
            }
        }

        return validMoves
    }

    @Suppress("NestedBlockDepth", "CyclomaticComplexMethod")
    private fun buildMovementCombinations(currentFloor: List<String>): MutableList<MutableList<String>> {
        // get possible movement combos
        val movementCombinations = mutableListOf<MutableList<String>>()

        // 1. We can move individual items
        for (item in currentFloor) {
            movementCombinations.add(mutableListOf(item))
        }

        for (index01 in 0..<currentFloor.size) {
            for (index02 in index01..<currentFloor.size) {
                val thisItem = currentFloor[index01]
                val nextItem = currentFloor[index02]
                if (thisItem == nextItem) {
                    continue
                }

                if (thisItem.endsWith(GENERATOR) && nextItem.endsWith(GENERATOR)) {
                    // 2. we can move 2 generators
                    movementCombinations.add(mutableListOf(thisItem, nextItem))
                } else if (thisItem.endsWith(MICROCHIP) && nextItem.endsWith(MICROCHIP)) {
                    // 3. we can move 2 microchips
                    movementCombinations.add(mutableListOf(thisItem, nextItem))
                } else if (thisItem.endsWith(GENERATOR) && nextItem.endsWith(MICROCHIP)) {
                    // 4. we can move a microchip and generator if they are the same element
                    val element = thisItem.split(" ")[0]
                    if (nextItem.startsWith(element)) {
                        movementCombinations.add(mutableListOf(thisItem, nextItem))
                    }
                } else if (thisItem.endsWith(MICROCHIP) && nextItem.endsWith(GENERATOR)) {
                    val element = nextItem.split(" ")[0]
                    if (thisItem.startsWith(element)) {
                        movementCombinations.add(mutableListOf(thisItem, nextItem))
                    }
                } else {
                    error("Weird additional combination")
                }
            }
        }
        return movementCombinations
    }

    private fun buildNextState(
        currentElevator: Int,
        nextElevator: Int,
        currentFloorToBe: MutableList<String>,
        nextFloorToBe: MutableList<String>,
        state: State,
    ): State {
        var validState: State
        if (FLOOR_ONE == currentElevator && FLOOR_TWO == nextElevator) {
            validState =
                State(
                    nextElevator,
                    currentFloorToBe.toSet(),
                    nextFloorToBe.toSet(),
                    state.floorThree,
                    state.floorFour,
                )
        } else if (FLOOR_TWO == currentElevator && FLOOR_THREE == nextElevator) {
            validState =
                State(
                    nextElevator,
                    state.floorOne,
                    currentFloorToBe.toSet(),
                    nextFloorToBe.toSet(),
                    state.floorFour,
                )
        } else if (FLOOR_THREE == currentElevator && FLOOR_FOUR == nextElevator) {
            validState =
                State(
                    nextElevator,
                    state.floorOne,
                    state.floorTwo,
                    currentFloorToBe.toSet(),
                    nextFloorToBe.toSet(),
                )
        } else if (FLOOR_FOUR == currentElevator && FLOOR_THREE == nextElevator) {
            validState =
                State(
                    nextElevator,
                    state.floorOne,
                    state.floorTwo,
                    nextFloorToBe.toSet(),
                    currentFloorToBe.toSet(),
                )
        } else if (FLOOR_THREE == currentElevator && FLOOR_TWO == nextElevator) {
            validState =
                State(
                    nextElevator,
                    state.floorOne,
                    nextFloorToBe.toSet(),
                    currentFloorToBe.toSet(),
                    state.floorFour,
                )
        } else {
            validState =
                State(
                    nextElevator,
                    nextFloorToBe.toSet(),
                    currentFloorToBe.toSet(),
                    state.floorThree,
                    state.floorFour,
                )
        }
        return validState
    }

    @Suppress("ReturnCount", "CyclomaticComplexMethod")
    private fun floorIsValid(floor: List<String>): Boolean {
        // 1. if floor is empty or one item return true
        if (floor.size == 0 || floor.size == 1) {
            return true
        }

        // 2. if all items are generators return true
        var allGenerators = true
        for (item in floor) {
            if (!item.endsWith(GENERATOR)) {
                allGenerators = false
                break
            }
        }
        if (allGenerators) {
            return true
        }

        // 3. if all items are microchips return true
        var allMicrochips = true
        for (item in floor) {
            if (!item.endsWith(MICROCHIP)) {
                allMicrochips = false
                break
            }
        }
        if (allMicrochips) {
            return true
        }

        // 4. for each chip, does it have a generator ,all paired return true
        var chipsHaveGenerators = true
        for (item in floor) {
            if (item.endsWith(MICROCHIP)) {
                val element = item.split("-")[0]
                if (!floor.contains(element + " " + GENERATOR)) {
                    chipsHaveGenerators = false
                    break
                }
            }
        }
        if (chipsHaveGenerators) {
            return true
        }
        return false
    }
}
