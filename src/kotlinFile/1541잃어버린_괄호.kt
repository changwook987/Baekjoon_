package kotlinFile

fun main() = println(readln().split("-").map { s -> s.split("+").sumOf { it.toInt() } }.reduce { a, i -> a - i })