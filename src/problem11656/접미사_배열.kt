package problem11656

fun main() = println(readLine()!!.run { List(length) { substring(it) } }.sorted().joinToString("\n"))
