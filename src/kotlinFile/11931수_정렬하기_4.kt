package kotlinFile

fun main() = println(List(readLine()!!.toInt()) { readLine()!!.toInt() }.sortedDescending().joinToString("\n"))