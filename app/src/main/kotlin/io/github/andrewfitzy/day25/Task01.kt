package io.github.andrewfitzy.day25

// Reduce this value to speed up but if the length is too short the correct answer may not be found
private const val MINIMUM_REPEATING_LENGTH = 16

class Task01(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    fun solve(): Int {
        var lowestValue = -1
        for (registerValue in 0..Integer.MAX_VALUE) {
            if (solvedWithA(registerValue)) {
                lowestValue = registerValue
                break
            }
        }
        return lowestValue
    }

    private fun solvedWithA(a: Int): Boolean {
        val registerMap: MutableMap<String, Int> = mutableMapOf()
        registerMap["a"] = a
        var pointer = 0
        val builder = StringBuilder()
        while (pointer < input.size) {
            val line = input[pointer]
            var pointerShift = 1
            if (line.startsWith("jnz")) {
                pointerShift = jump(line, registerMap)
            } else if (line.startsWith("cpy")) {
                copy(line, registerMap)
            } else if (line.startsWith("inc")) {
                increase(line, registerMap)
            } else if (line.startsWith("dec")) {
                decrease(line, registerMap)
            } else if (line.startsWith("out")) {
                builder.append(output(line, registerMap))
                if (builder.length == MINIMUM_REPEATING_LENGTH) {
                    break
                }
            } else {
                println("UNKNOWN: $line")
            }
            pointer += pointerShift
        }
        return builder.matches("^(01)+0?\$".toRegex())
    }

    private fun jump(
        line: String,
        registerMap: MutableMap<String, Int>,
    ): Int {
        var pointerShift = 1
        val (_, register, change) = line.split(" ")
        val regInt =
            if (register.matches("-?\\d+".toRegex())) {
                register.toInt()
            } else {
                registerMap.getOrDefault(register, 0)
            }
        if (regInt != 0) {
            pointerShift = change.toInt()
        }
        return pointerShift
    }

    private fun copy(
        line: String,
        registerMap: MutableMap<String, Int>,
    ) {
        val (_, value, register) = line.split(" ")
        if (value.matches("-?\\d+".toRegex())) {
            val source = value.toInt()
            registerMap[register] = source
        } else if (registerMap.contains(value)) {
            val source = registerMap[value]!!
            registerMap[register] = source
        }
    }

    private fun increase(
        line: String,
        registerMap: MutableMap<String, Int>,
    ) {
        val (_, register) = line.split(" ")
        val registerVal = registerMap.getOrDefault(register, 0)
        registerMap[register] = registerVal + 1
    }

    private fun decrease(
        line: String,
        registerMap: MutableMap<String, Int>,
    ) {
        val (_, register) = line.split(" ")
        val registerVal = registerMap.getOrDefault(register, 0)
        registerMap[register] = registerVal - 1
    }

    private fun output(
        line: String,
        registerMap: MutableMap<String, Int>,
    ): String {
        val (_, register) = line.split(" ")
        return registerMap[register].toString()
    }
}
