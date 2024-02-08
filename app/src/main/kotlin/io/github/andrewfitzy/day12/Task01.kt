package io.github.andrewfitzy.day12

class Task01(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    fun solve(): Int {
        val registerMap: MutableMap<String, Int> = mutableMapOf()
        var pointer = 0
        while (pointer < input.size) {
            val line = input[pointer]
            var pointerShift = 1
            if (line.startsWith("jnz")) {
                pointerShift = jump(line, registerMap)
            }
            if (line.startsWith("cpy")) {
                copy(line, registerMap)
            }
            if (line.startsWith("inc")) {
                increase(line, registerMap)
            }
            if (line.startsWith("dec")) {
                decrease(line, registerMap)
            }
            pointer += pointerShift
        }
        return registerMap["a"]!!
    }

    private fun jump(
        line: String,
        registerMap: MutableMap<String, Int>,
    ): Int {
        var pointerShift = 1
        val (_, register, change) = line.split(" ")
        val regInt = if (register.matches("\\d+".toRegex())) register.toInt() else registerMap.getOrDefault(register, 0)
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
        if (value.matches("\\d+".toRegex())) {
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
}
