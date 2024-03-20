package io.github.andrewfitzy.day23

class Task01(puzzleInput: List<String>) {
    private val input: MutableList<String> = puzzleInput.toMutableList()

    fun solve(a: Int): Int {
        val registerMap: MutableMap<String, Int> = mutableMapOf()
        registerMap["a"] = a

        var pointer = 0
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
            } else if (line.startsWith("tgl")) {
                toggle(line, registerMap, pointer, input)
            } else {
                println("UNKNOWN : $line")
            }
            pointer += pointerShift
        }
        return registerMap["a"]!!
    }

    private fun toggle(
        line: String,
        registerMap: MutableMap<String, Int>,
        pointer: Int,
        input: MutableList<String>,
    ) {
        val (_, valueOrRegister) = line.split(" ")

        val distance =
            if (valueOrRegister.matches("-?\\d+".toRegex())) {
                valueOrRegister.toInt()
            } else {
                registerMap.getOrDefault(valueOrRegister, 0)
            }

        val targetPointer = pointer + distance
        if (targetPointer > input.lastIndex) {
            return
        }

        val targetCommandParts = input[targetPointer].split(" ").toMutableList()

        when (targetCommandParts[0]) {
            "jnz" -> targetCommandParts[0] = "cpy"
            "cpy" -> targetCommandParts[0] = "jnz"
            "inc" -> targetCommandParts[0] = "dec"
            "dec" -> targetCommandParts[0] = "inc"
            "tgl" -> targetCommandParts[0] = "inc"
        }

        input[targetPointer] = targetCommandParts.joinToString(separator = " ")
    }

    private fun jump(
        line: String,
        registerMap: MutableMap<String, Int>,
    ): Int {
        var pointerShift = 1
        val (_, register, change) = line.split(" ")

        val changeInt =
            if (change.matches("-?\\d+".toRegex())) {
                change.toInt()
            } else {
                registerMap.getOrDefault(change, 0)
            }

        val regInt =
            if (register.matches("-?\\d+".toRegex())) {
                register.toInt()
            } else {
                registerMap.getOrDefault(register, 0)
            }
        if (regInt != 0) {
            pointerShift = changeInt
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
}
