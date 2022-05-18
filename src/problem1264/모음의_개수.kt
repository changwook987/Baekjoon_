package problem1264

fun main() = System.out.bufferedWriter().use { w ->
    while (true) {
        val input = readln()
        if (input == "#") break
        w.appendLine("${input.filter { it.lowercase() in "aeiou" }.length}")
    }
    w.flush()
}