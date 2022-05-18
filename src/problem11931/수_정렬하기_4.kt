package problem11931

fun main() = println(List(readLine()!!.toInt()) { readLine()!!.toInt() }.sortedDescending().joinToString("\n"))