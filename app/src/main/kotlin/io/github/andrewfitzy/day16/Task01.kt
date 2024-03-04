package io.github.andrewfitzy.day16

class Task01(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput

    fun solve(diskSize: Int): String {
        var a: String = input[0]
        while(a.length < diskSize) {
            val b = getB(a)
            a = a + "0" + b
        }
        val diskData = a.substring(0, diskSize)
        val checksum = getChecksum(diskData)
        return checksum
    }

    private fun getChecksum(diskData: String): String {
        var checksumData = diskData.toList()
        var checksumBuilder = StringBuilder()
        while(checksumBuilder.length % 2 == 0) {
            checksumBuilder = StringBuilder()
            for (i in 1 .. checksumData.size step 2) {
                if (checksumData[i] == checksumData[i - 1]) {
                    checksumBuilder.append("1")
                } else {
                    checksumBuilder.append("0")
                }
            }
            checksumData = checksumBuilder.toList()
        }
        return checksumBuilder.toString()
    }

    private fun getB(a: String): String {
        val b = StringBuilder()
        val aStringChars = a.toList()
        for (character in aStringChars) {
            when (character) {
                '1' -> b.append("0")
                '0' -> b.append("1")
            }
        }
        return b.reversed().toString()
    }
}
