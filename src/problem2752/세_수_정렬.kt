package problem2752

fun main() = readLine()!!.split(' ').sortedWith(compareBy { it.toInt() }).forEach { print("$it ") }