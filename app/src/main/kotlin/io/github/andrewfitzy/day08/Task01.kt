package io.github.andrewfitzy.day08

class Task01(rowsInput: Int, colsInput: Int, puzzleInput: List<String>) {
    private val rows: Int = rowsInput
    private val cols: Int = colsInput
    private val input: List<String> = puzzleInput

    fun solve(): Int {
        val display: Array<CharArray> = Array(rows) { CharArray(cols) { '.' } }
        for (line in input) {
            if (line.startsWith("rect")) {
                // rect AxB
                val rectangle = line.split(" ")[1]
                val width = rectangle.split("x")[0].toInt()
                val height = rectangle.split("x")[1].toInt()
                illuminate(width, height, display)
            }
            if (line.startsWith("rotate column")) {
                val rotation = line.split("=")[1]
                val column = rotation.split(" by ")[0].toInt()
                val pixels = rotation.split(" by ")[1].toInt()
                rotateColumn(column, pixels, display)
            }
            if (line.startsWith("rotate row")) {
                val rotation = line.split("=")[1]
                val row = rotation.split(" by ")[0].toInt()
                val pixels = rotation.split(" by ")[1].toInt()
                rotateRow(row, pixels, display)
            }
        }
        return countIlluminated(display)
    }

    private fun rotateRow(
        row: Int,
        pixels: Int,
        display: Array<CharArray>,
    ) {
        val rowList = display[row].toList()
        val leftSplit = rowList.subList(0, rowList.size - pixels)
        val rightSplit = rowList.subList(rowList.size - pixels, rowList.size)
        val newRowList = rightSplit + leftSplit
        for (i in newRowList.indices) {
            display[row][i] = newRowList[i]
        }
    }

    private fun rotateColumn(
        column: Int,
        pixels: Int,
        display: Array<CharArray>,
    ) {
        val colList: MutableList<Char> = mutableListOf()
        for (element in display) {
            colList.add(element[column])
        }

        val topSplit = colList.subList(0, colList.size - pixels)
        val bottomSplit = colList.subList(colList.size - pixels, colList.size)
        val newColList = bottomSplit + topSplit

        for (i in newColList.indices) {
            display[i][column] = newColList[i]
        }
    }

    private fun illuminate(
        width: Int,
        height: Int,
        display: Array<CharArray>,
    ) {
        for (i in 0 until height) {
            for (j in 0 until width) {
                display[i][j] = '#'
            }
        }
    }

    private fun countIlluminated(display: Array<CharArray>): Int {
        var count = 0
        for (element in display) {
            for (j in 0 until display[0].size) {
                if (element[j] == '#') {
                    count++
                }
            }
        }
        return count
    }
}
