package kotlinFile

fun main() = println("${List(10) { readLine()!!.toInt() }.sorted().run { get(7) + get(8) + get(9) }} ${List(10) { readLine()!!.toInt() }.sorted().run { get(7) + get(8) + get(9) }}")