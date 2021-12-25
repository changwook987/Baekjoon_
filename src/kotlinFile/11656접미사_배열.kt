package kotlinFile

fun main() = println(readLine()!!.run { List(length) { substring(it) } }.sorted().joinToString("\n"))
