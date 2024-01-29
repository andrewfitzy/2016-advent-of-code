import java.io.File

fun getFileContentForDay(day: String): List<String> = getFileContent("./src/test/resources/day$day/task01_input.txt")

fun getFileContent(fileName: String): List<String> = File(fileName).useLines { it.toList() }
