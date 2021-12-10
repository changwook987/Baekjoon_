package kotlinFile

fun main() = println(List(5) { kotlin.math.max(readLine()!!.toInt(), 40) }.average().toInt())