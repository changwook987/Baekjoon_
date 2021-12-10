package kotlinFile

fun main() = readLine()!!.split(' ').sortedWith(compareBy { it.toInt() }).forEach { print("$it ") }