import java.io.File

fun getFileContentForDay(day: String, task: String = "01"): List<String> = getFileContent("./src/test/resources/day$day/task${task}_input.txt")

fun getFileContent(fileName: String): List<String> = File(fileName).useLines { it.toList() }
