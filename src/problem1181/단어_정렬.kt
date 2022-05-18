package problem1181

fun main () = List(readLine()!!.toInt()) { readLine()!! }.toSet().sortedWith(compareBy({ it.length }, { it })).forEach { println(it) }