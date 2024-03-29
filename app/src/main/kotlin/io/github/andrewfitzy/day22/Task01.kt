package io.github.andrewfitzy.day22

class Task01(puzzleInput: List<String>) {
    private val input: List<String> = puzzleInput
    private val nodeRegex = "/dev/grid/node-x(\\d+)-y(\\d+) +(\\d+)T +(\\d+)T +(\\d+)T +(\\d+)%".toRegex()

    fun solve(): Int {
        val nodes = input.filter { line -> line.startsWith("/") }.map { line -> toNode(line) }
        val viablePairs = mutableListOf<Pair<Node, Node>>()
        for (i in 0..nodes.lastIndex) {
            for (j in i + 1..nodes.lastIndex) {
                if (nodes[i].used > 0 && nodes[i].used <= nodes[j].available) {
                    viablePairs.add(Pair(nodes[i], nodes[j]))
                }
                if (nodes[j].used > 0 && nodes[j].used <= nodes[i].available) {
                    viablePairs.add(Pair(nodes[j], nodes[i]))
                }
            }
        }
        return viablePairs.size
    }

    @Suppress("DestructuringDeclarationWithTooManyEntries")
    private fun toNode(line: String): Node {
        val matchResult = nodeRegex.find(line)!!
        print(matchResult.groups[1])
        val (x, y, size, used, available, usedPercentage) = matchResult.destructured
        return Node(x.toInt(), y.toInt(), size.toInt(), used.toInt(), available.toInt(), usedPercentage.toInt())
    }
}
